package perfchecker;



import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import soot.MethodOrMethodContext;
import soot.PackManager;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.toolkits.callgraph.CHATransformer;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.ReachableMethods;
import soot.options.Options;
import soot.util.queue.QueueReader;

public final class Checker1 {
  	public static void check(String classPath, String checkWhat) {
  		int checkGUI = 0, checkLifecycle = 0;
  		if (checkWhat.equalsIgnoreCase("gui")) {
  			checkGUI = 1;
  		} else if (checkWhat.equalsIgnoreCase("lifecycle")) {
  			checkLifecycle = 1;
  		} else {
  			return;
  		}
  		URL[] systemClasses = ((URLClassLoader) ClassLoader.getSystemClassLoader()).getURLs();
  		System.out.println("class paths:");
  		for (URL systemClass : systemClasses)
  			System.out.println(systemClass.getFile());
  		System.out.println("--end");
  		File fileClassPath = new File(classPath);
  		ArrayList<String> classesFounded = new ArrayList<String>();
  		ClassFinder.find(fileClassPath, null, classesFounded);
  		Options.v().set_whole_program(true);
  		Iterator<String> itClassFounded = classesFounded.iterator();
  		ArrayList<String> toAnalyseList = new ArrayList<String>();
  		
  		
    	while (itClassFounded.hasNext()) {
    		String className = itClassFounded.next();
    		try	{
    			Class cl = Class.forName(className);
    			System.out.println("Found Class : " + className);
    			boolean toAnalyse = false;
    			if (checkGUI != 0 && className.contains("$")) {
    				for (Class clInterface : cl.getInterfaces()) {
    					if (ListenerList.list.contains(clInterface.getName())) {
    						toAnalyse = true;
    					}
    				}
    			} else if (checkLifecycle != 0) {
    				Class tmp = cl;
    				while (tmp.getSuperclass() != null) {
    					if (tmp.getName().contains("android.app.Activity")) {
    						toAnalyse = true;
    					}
    					tmp = tmp.getSuperclass();
    				}
    			}
    			if (toAnalyse) {
    				toAnalyseList.add(className);
    			}
    		} catch (ExceptionInInitializerError e) {
    	        System.err.println("[Error ExceptionInInitializerError] " + e.getMessage());
    	    } catch (NoClassDefFoundError e) {
    	        System.err.println("[Error NoClassDefFoundError] " + e.getMessage());
    	    } catch (UnsatisfiedLinkError e) {
    	        System.err.println("[Error UnsatisfiedLinkError] " + e.getMessage());
    	    } catch (ClassNotFoundException e) {
    	        System.err.println("[Error ClassNotFoundException] " + e.getMessage());
    	    } catch (Exception e) {
    	        System.err.println("[Error] " + e.getMessage());
    	    }
    	}
    	Iterator<String> itToAnalyse = toAnalyseList.iterator();
    	

    	Result result = new Result();
    	while (itToAnalyse.hasNext()) {
    		String className = itToAnalyse.next();
    		try {
    			System.out.println("Analyzing class " + className);
    			Options.v().set_whole_program(true);
    			SootClass sootClass = Scene.v().forceResolve(className, 3);
    			Scene.v().loadNecessaryClasses();
    			List<SootMethod> methods = sootClass.getMethods();
    			ArrayList<SootMethod> entrypoints = new ArrayList<SootMethod>();
        		Iterator<SootMethod> itMethods = methods.iterator();
        		while (itMethods.hasNext()) {
        			SootMethod method = itMethods.next();
        			if (method.getName().startsWith("on")) {
        				entrypoints.add(method);
        			}
        		}
        		Iterator<SootMethod> itEntrypoints = entrypoints.iterator();
        		while (itEntrypoints.hasNext()) {
        			SootMethod method = itEntrypoints.next();
        			System.out.println("Checking entrypoint : " + method.getSignature());
        			ArrayList<SootMethod> listEntrypoint = new ArrayList<SootMethod>();
        			listEntrypoint.add(method);
        			Scene.v().setEntryPoints(listEntrypoint);
        			try {
        				CHATransformer.v().transform();
        				PackManager.v().runPacks();
        			} catch (Exception e) {
        				System.err.println("[Error] " + e.getMessage());
        			}
        			CallGraph CG = Scene.v().getCallGraph();
        			ArrayList<SootMethod> listMe = new ArrayList<SootMethod>();
        			listMe.add(method);
          			ReachableMethods rm = new ReachableMethods(CG, (Collection)listMe);
          			rm.update();
          			QueueReader<MethodOrMethodContext> reader = (rm).listener();
          			while (reader.hasNext()) {
          				SootMethod tgtMethod = (SootMethod)(reader).next();
          				if (LengthyOprList.list.contains(tgtMethod.getSignature())) {
          					result.addResult(sootClass, method, "MAY CALL " + tgtMethod.getSignature());
          				}
          			}
        		} 
    		} catch (Exception e) {
    			System.err.println("Error : " + e.getMessage());
    		}
    	}
    	
    	result.printResult();
    }

}

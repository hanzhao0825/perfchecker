package perfchecker;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Iterator;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.pdg.HashMutablePDG;
import soot.toolkits.graph.pdg.PDGNode;

public final class Checker2
{
  	public static void check(String classPath){
		URL[] systemClasses = ((URLClassLoader) ClassLoader.getSystemClassLoader()).getURLs();
		System.out.println("class paths:");
		for (URL systemClass : systemClasses)
			System.out.println(systemClass.getFile());
		System.out.println("--end");
		File fileClassPath = new File(classPath);
		ArrayList<String> classesFounded = new ArrayList<String>();
		ClassFinder.find(fileClassPath, null, classesFounded);
	
    
  		Iterator<String> itClassFounded = classesFounded.iterator();
  		ArrayList<String> toAnalyseList = new ArrayList<String>();
  		while (itClassFounded.hasNext()) {
  			String className = itClassFounded.next();
  			try {
  				Class cl = Class.forName(className);
    			System.out.println("Found Class : " + className);
  				boolean toAnalyse = false;
  				Class tmp = cl;
				while (tmp.getSuperclass() != null) {
					if (tmp.getName().contains("android.widget.BaseAdapter") 
							|| tmp.getName().contains("android.widget.ListAdapter")
							|| tmp.getName().contains("android.widget.SpinnerAdapter")
							) {
						toAnalyse = true;
					}
					tmp = tmp.getSuperclass();
				}
				if (toAnalyse) {
					Scene.v().loadClassAndSupport(className);
                	toAnalyseList.add(className);
				}
  			} catch (ExceptionInInitializerError e) {
  				System.err.println("[Error] ExceptionInIntializerError: " + e.getMessage()); 
  			} catch (NoClassDefFoundError e) {
  				System.err.println("[Error] NoClassDefFoundError: " + e.getMessage()); 
  			} catch (ClassNotFoundException e) {
  				System.err.println("[Error] ClassNotFoundException: " + e.getMessage());
  			} catch (Exception e) {
  				System.err.println("[Error] " + e.getMessage());
  			}
  		}
    
  		Result result = new Result();
    	Iterator<String> itAnalyseList = toAnalyseList.iterator();
    	while (itAnalyseList.hasNext()) {
    		String className = itAnalyseList.next();
			System.out.println("Analyzing class " + className);
    		SootClass cl = Scene.v().forceResolve(className, 3);
    		SootMethod me;
      		try {
      			me = cl.getMethod("android.view.View getView(int,android.view.View,android.view.ViewGroup)");

      			ExceptionalUnitGraph EUG = new ExceptionalUnitGraph(me.retrieveActiveBody());
      			HashMutablePDG PDG = new HashMutablePDG(EUG);

      			Iterator<Object> itNodes = (PDG.getNodes()).iterator();
      			boolean checked = false;
      			while (itNodes.hasNext()) {
      				Object o = itNodes.next();
      				if (!(o instanceof PDGNode)) continue;
      				PDGNode node = (PDGNode)o;
      				if (node.getType() == PDGNode.Type.CFGNODE) {
      					if (node.toString().contains("r1 == null") || node.toString().contains("r1 != null")) {
      						checked = true;
      					}
      				}
      			}
      			if (!checked) {
      				result.addResult(cl, me, "Recycled View Not Used");
      			}
      		} catch (Exception e) {
      		}
    	}
    	result.printResult();
  	}

}

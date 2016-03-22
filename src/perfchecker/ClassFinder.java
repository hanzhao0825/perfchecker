package perfchecker;

import java.io.File;
import java.util.ArrayList;

public class ClassFinder {
	public static void find(File fileClassPath, String prefix, ArrayList<String> classesFounded) {
	    if (fileClassPath.exists()) {
	    	File[] Files;
	    	Files = fileClassPath.listFiles();
	    	for (int i = 0; i < Files.length; i++) {
	    		fileClassPath = Files[i];
	    		if (fileClassPath.isDirectory() && (!fileClassPath.getName().contains("."))) {
	    			if (prefix == null)
	    				find(fileClassPath, fileClassPath.getName(), classesFounded);
	    			else
	    				find(fileClassPath, prefix + "." + fileClassPath.getName(), classesFounded);
	    		} else if (fileClassPath.getName().endsWith(".class"))
	    			if (prefix != null)
	    				classesFounded.add(prefix + '.' + fileClassPath.getName().substring(0, fileClassPath.getName().length() - 6));
	    			else
	    				classesFounded.add(fileClassPath.getName().substring(0, fileClassPath.getName().length() - 6));
	    	}
	    }
	}
}

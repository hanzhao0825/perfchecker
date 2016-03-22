package perfchecker;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int mode = 3; // 1 for lifecycle, 2 for gui, 3 for viewholder
		String classPath = "/Users/nikifor40/Downloads/perfchecker/example/Omnidroid-r863/bin/classes/";
		if (mode == 1) {
			Checker1.check(classPath, "lifecycle");
		} else if (mode == 2) {
			Checker1.check(classPath, "gui");
		} else if (mode == 3) {
			Checker2.check(classPath);
		}
	}
}

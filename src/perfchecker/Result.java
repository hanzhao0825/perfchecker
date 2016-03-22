package perfchecker;

import java.util.ArrayList;
import java.util.Iterator;

import soot.SootClass;
import soot.SootMethod;

public class Result {
	public ArrayList<Entry> list;
	
	public Result() {
		list = new ArrayList<Entry>();
	}
	
	public void addResult(SootClass cl, SootMethod me, String comment) {
		Entry e = new Entry(cl, me, comment);
		if (!list.contains(e)) {
			list.add(e);
		}
	}
	public void printResult() {
		System.out.println("\nPrinting Results");
		for (Iterator<Entry> it = list.iterator(); it.hasNext(); ) {
			Entry e = it.next();
			System.out.println(e.me.getSignature() + " : " + e.comment);
		}
	}
}

class Entry {
	public SootClass cl;
	public SootMethod me;
	public String comment;
	
	public Entry(SootClass cl, SootMethod me, String comment) {
		this.cl = cl;
		this.me = me;
		this.comment = comment;
	}
	
	public boolean equals(Entry e) {
		return (this.cl == e.cl) && (this.me == e.me) && (this.comment == e.comment);
	}
}

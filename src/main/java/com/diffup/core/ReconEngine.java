package com.diffup.core;

import java.util.Comparator;
import java.util.List;

public class ReconEngine {

	public <T extends Updatable> void doRecon(List<T> dbObjs, List<T> origObjs, Comparator<T> comparator) {

		dbObjs.sort(comparator);
		origObjs.sort(comparator);
		
		System.out.println(dbObjs);
		System.out.println(origObjs);
		
		for (T origObj : origObjs) {
			if (dbObjs.contains(origObj)) {
				// remove this Obj, so remaining objects are those don't belong
				// to original objects
				dbObjs.remove(origObj);
			} else {
				origObj.insert();
			}
		}
		
		dbObjs.forEach(Updatable::delete);
	}

}

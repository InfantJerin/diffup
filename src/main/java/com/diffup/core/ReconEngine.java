package com.diffup.core;

import java.util.Comparator;
import java.util.List;

public class ReconEngine {

	/**
	 * 
	 * @param dbObjs database objects
	 * @param origObjs original Objects
	 * @param comparator pass the comparator to sort them
	 */
	public <T extends Updatable> void doRecon(List<T> dbObjs, List<T> origObjs, Comparator<T> comparator) {

		dbObjs.sort(comparator);
		origObjs.sort(comparator);
		
		System.out.println(dbObjs);
		System.out.println(origObjs);
		
		doDiferentialUpdate(dbObjs, origObjs);
	}

	/**
	 * 
	 * @param dbObjs - sorted database objects
	 * @param origObjs - sorted original objects
	 */
	public <T extends Updatable> void doRecon(List<T> dbObjs, List<T> origObjs) {

		System.out.println(dbObjs);
		System.out.println(origObjs);
		
		doDiferentialUpdate(dbObjs, origObjs);
	}
	
	private <T extends Updatable> void doDiferentialUpdate(List<T> dbObjs, List<T> origObjs) {
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

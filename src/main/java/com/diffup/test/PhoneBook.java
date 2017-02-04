package com.diffup.test;

import com.diffup.core.Updatable;

public class PhoneBook implements Updatable{

	String id;
	
	@Override
	public void delete() {
		
		System.out.println("Delete : "+ id);
	}

	@Override
	public void insert() {
		System.out.println("Insert : "+ id);
		
	}

}

package com.diffup.test;

import com.diffup.core.Updatable;

public class Address implements Updatable {
	
	String id;

	String name;
	
	String address;
	@Override
	public void delete() {
		System.out.println("delete from Address where id="+ id);
	}

	@Override
	public void insert() {
		System.out.println("Insert into Address values("+id+" ," + name+")");
	}
	
	@Override
	public boolean equals(Object obj) {
		 if(obj instanceof Address ){
		        final Address other = (Address) obj;
		        return other.id.equals(id);
		        
		    } else{
		        return false;
		    }
	}
	
	@Override
	public String toString() {
		return "Address [ id = "+ id + ": name = "+ name +" ]"; 
	}

}

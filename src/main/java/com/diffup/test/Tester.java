package com.diffup.test;

import java.util.ArrayList;

import com.diffup.core.ReconEngine;

public class Tester {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();

		// p1
		p1.address = new ArrayList<>();
		p1.phoneBook = new ArrayList<>();

		p1.address.add(getAddress("123", "Jerin"));
		p1.address.add(getAddress("124", "Hari"));
		p1.address.add(getAddress("120", "Hari"));

		p1.phoneBook.add(getPhoneBook("123"));

		// p2
		p2.address = new ArrayList<>();
		p2.phoneBook = new ArrayList<>();

		p2.address.add(getAddress("125", "Jerin"));
		p2.address.add(getAddress("124", "Hari"));
		p2.address.add(getAddress("121", "Hari"));


		p2.phoneBook.add(getPhoneBook("123"));
		p2.phoneBook.add(getPhoneBook("12378"));
		
		ReconEngine engine = new ReconEngine();
		engine.doRecon(p1.address, p2.address, (db,or) -> db.address.compareTo(or.address));
		engine.doRecon(p1.phoneBook, p2.phoneBook,(db,or) -> db.id.compareTo(or.id));


	}

	private static PhoneBook getPhoneBook(String string) {
		PhoneBook p = new PhoneBook();
		p.id = string;
		return p;
	}

	private static Address getAddress(String id, String name) {
		Address a = new Address();
		a.id = id;
		a.name = name;
		a.address = "43/Mannarpuram";
		return a;
	}
}

package com.hpe.java.day0717;

public class CommonEmployee extends Employee{
	
	public CommonEmployee() {
		super();
	}

	public CommonEmployee(String name, String id, double salary) {
		super(name, id, salary);
	}

	@Override
	public void work() {

		System.out.println("CommonEmployee");
	}

}
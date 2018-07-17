package com.hpe.java.day0717;

public class Employee1 extends Role{

	private final String id ;
	private static String company;
	private double salary;

	public static String getCompany() {
		return company;
	}

	public static void setCompany(String company) {
		Employee1.company = company;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public Employee1(String id) {
		super();
		this.id = id;
		System.out.println("Employee:有参(id)构造函数");
	}

	public Employee1(String name, int age, String sex, String id, double salary) {
		super(name, age, sex);
		this.id = id;
		this.salary = salary;
		System.out.println("Employee:有参构造函数");
	}
	
	public Employee1() {
		super();
		this.id = "0001";
	}

	public Employee1(String name, int age, String sex) {
		super(name, age, sex);
		this.id = "0001";
	}

	@Override
	public void play() {
		System.out.println("Employee:重写的play()");
		System.out.println("调用Role的say()");
		super.say();
	}

	@Override
	public String toString() {
		return "Employee1 [id=" + id + ", salary=" + salary + "]";
	}
	
	

}

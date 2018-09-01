package com.empmap.po;

/**
 * @author chaoling
 * @date 2018年7月16日下午8:26:58
 * @Description
 */
public class Director extends Employee{
	
	public Director() {
		super();
	}

	public Director(String iD, String name, String postition, int holiday, double salary) {
		super(iD, name, postition, holiday, salary);
	}

	public double sumSalary() {
		return super.sumSalary() + super.getSalary()*(1+0.2+0.5)+500;
	}
}
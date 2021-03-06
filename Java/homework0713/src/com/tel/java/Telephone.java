package com.tel.java;
/**
 * 
 * @author chaoling
 * @date 2018年7月17日下午4:25:33
 * @Description
 */
public class Telephone {
	
	private String name;
	private String sex;
	private int age;
	private String tel;
	private String qq;
	private String address;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getQq() {
		return qq;
	}
	
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public Telephone(String name, String sex, int age, String tel, String qq, String address) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.tel = tel;
		this.qq = qq;
		this.address = address;
	}

	public Telephone() {
		super();
	}

	@Override
	public String toString() {
		return "Telephone [name=" + name + ", sex=" + sex + ", age=" + age + ", tel=" + tel + ", qq=" + qq
				+ ", address=" + address + "]";
	}
	
	
	
}

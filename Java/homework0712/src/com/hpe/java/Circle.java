package com.hpe.java;

public class Circle {

	private double radius; // 存放圆的半径

	public Circle() {
		// 将半径设为0
		this.radius = 0;
	}

	public Circle(double r) {
		// 将形参r的值赋值给radius
		this.radius = r;
	}

	public double getArea() {
		// 返回面积radius*radius*3.14
		return Math.pow(this.radius, 2) * Math.PI;
	}

	public double getPerimeter() {
		// 返回周长radius * 2 * Math.PI
		return this.radius * 2 * Math.PI;
	}

	public void show() {
		System.out.println("圆的半径：" + this.radius);
		System.out.println("圆的周长：" + this.getPerimeter());
		System.out.println("圆的面积：" + this.getArea());
	}
}

package com.hpe.java.day0717;
/**
 * 
 * @author chaoling
 * @date 2018年7月17日下午7:11:03
 * @Description
 */
public class InterfaceDemo {
	public static void main(String[] args) {
		Vehicle bike = new Bike();
		bike.start();
		bike.stop();
		Vehicle bus = new Bus();
		bus.start();
		bus.stop();
	}

}

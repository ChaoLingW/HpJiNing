package com.hpe.java.day0717;

import sun.awt.AWTAccessor.SystemColorAccessor;

/**
 * 
 * @author chaoling
 * @date 2018年7月17日下午6:16:01
 * @Description
 */
public class Test {

	public static void main(String[] args) {

		//创建Manager类的对象，并调用work()
		Employee manager = new Manager();
		manager.work();
		
		//创建CommonEmployee类的对象，并调用work()
		Employee commonEmployee = new CommonEmployee();
		commonEmployee.work();
		
		//创建Car类的对象，并调用wheelsNum和run
		Vehicle1 car = new Car();
		car.wheelsNum();
		car.run();
		
		//创建Motorbike类的对象，并调用wheelsNum和run
		Vehicle1 motorbike = new Motorbike();
		motorbike.wheelsNum();
		motorbike.run();
		
		//创建FireProofDoor的对象，并调用所有的函数
		FireProofDoor fireProofDoor = new FireProofDoor();
		fireProofDoor.open();
		fireProofDoor.fireProof();
		fireProofDoor.close();

		//创建BulletProofDoor的对象，并调用所有的函数
		BulletProofDoor bulletProofDoor = new BulletProofDoor();
		bulletProofDoor.open();
		bulletProofDoor.bulletProof();
		bulletProofDoor.close();
		
		//题四
		System.out.println("题四");
		System.out.println("为company赋值");
		Employee1.setCompany("HP");
		System.out.println("company赋值完毕:" +Employee1.getCompany() );
		
		Employee1 e1 = new Employee1("001");
		Employee1 e2 = new Employee1("张三", 12, "男", "001", 2000);
		System.out.println("输出信息");
		System.out.println(e1);
		System.out.println(e2);
		
		e1.play();
		e1.sing();
		
		
	}

}
package com.hpe.java;

import java.util.Scanner;

import com.hpe.java.day0713.Addition;
import com.hpe.java.day0713.CircleHomework2;
import com.hpe.java.day0713.CylinderHomework2;
import com.hpe.java.day0713.Max;
import com.hpe.java.day0713.Min;
import com.hpe.java.day0713.PersonHomework9;
import com.hpe.java.day0713.StudentHomework2;
import com.hpe.java.day0713.StudentHomework4;
import com.hpe.java.day0713.StudentHomework7;
import com.hpe.java.day0713.TestCylinder;

public class Day0713 {

	public static void main(String[] args) {

		// 题一
		System.out.println("题一");
		TestCylinder.Test();

		// 题二
		System.out.println("题二");
		// 测试CircleHomework2类
		CircleHomework2 circle = new CircleHomework2(10);
		circle.show();
		// 测试CylinderHomework2类
		CylinderHomework2 cylinder = new CylinderHomework2(10, 1);
		cylinder.showVolume();
		
		//题三
		// 创建五个Student类的对象
		System.out.println("题三");
		StudentHomework2[] student = new StudentHomework2[5];
		student[0] = new StudentHomework2("001", "刘一", "男", 10, 88);
		student[1] = new StudentHomework2("002", "陈二", "女", 11, 65);
		student[2] = new StudentHomework2("003", "张三", "男", 12, 33);
		student[3] = new StudentHomework2("004", "李四", "女", 13, 75);
		student[4] = new StudentHomework2("005", "王五", "男", 14, 95);
		//输出每个学生的信息		
		for (StudentHomework2 s : student) 
			System.out.println(s.toString());
		//计算并输出这五个学生Java语言成绩的平均值，以及计算并输出他们Java语言成绩的最大值和最小值。（思路：对象数组）
		StudentHomework2.value(student);
		
		//题四
		System.out.println("题四");
		// 测试Addiction类
		Addition addition = new Addition();
		
		int aInt, bInt;
		aInt = bInt = 2;
		
		long aLong, bLong;
		aLong = bLong = 2;
		
		float aFloat, bFloat;
		aFloat = bFloat = 2;
		
		double aDouble, bDouble;
		aDouble = bDouble = 2;
		
		String aString, bString;
		aString = bString = "1";
		
		System.out.println(addition.add(aInt, bInt));
		System.out.println(addition.add(aLong, bLong));
		System.out.println(addition.add(aFloat, bFloat));
		System.out.println(addition.add(aDouble, bDouble));
		System.out.println(addition.add(aString, bString));
		
		//题五
		System.out.println("题五");
		
		StudentHomework4 s1 = new StudentHomework4("zhangsan", 20, "nan", "001");
		StudentHomework4 s2 = new StudentHomework4("lisi", 20, "nan", "002");
		StudentHomework4 s3 = new StudentHomework4("wangzu", 20, "nan", "003");
		
		s1.showInfo();
		s2.showInfo();
		s3.showInfo();
		
		//题六
		System.out.println("题六");
	
		//调用max比较大小
		int aMax=1;
		int bMax=2;
		int cMax=3;
		int dMax=4;
		
		System.out.println(Max.max(aMax,bMax));
		System.out.println(Max.max(cMax,dMax,aMax));
		System.out.println(Max.max(aMax,bMax,cMax,dMax));
		
		//题八
		System.out.println("题八");
		float[] arr = {84,75,95};
		StudentHomework7 s22 = new StudentHomework7("001","zhangsan",arr);
		float[] arr1 = {80,80,90};
		StudentHomework7 s23 = new StudentHomework7("001","zhangsan",arr);
		int[] arr2 = {80,79,90};
		System.out.println(Min.min(arr2));
		
		//题八
		System.out.println("题九");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入需要比较的整数的个数");
		
		int num = sc.nextInt();
		int[] arr8 = new int[num];
		
		for(int i = 0; i<num;i++){
			
			System.out.printf("请输入第%d个整数\n",(i+1));
			arr8[i] = sc.nextInt();
			
		}
		System.out.println("最小的整数是："+Min.min(arr8));
		
		
		//题十
		System.out.println("题十");
		PersonHomework9 person90 = new PersonHomework9("zhangsan",20);
		PersonHomework9 person91 = new PersonHomework9("lisi",20,"jining");
		PersonHomework9 person92 = new PersonHomework9("wangwu",20,"jining","student");
		
		person90.show();
		person91.show();
		person92.show();
		
		
		

	}

}

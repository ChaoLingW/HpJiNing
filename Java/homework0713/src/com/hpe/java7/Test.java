package com.hpe.java7;

import com.hpe.java.Min;

public class Test {

	public static void main(String[] args) {
		System.out.println("题八");
		float[] arr = { 84, 75, 95 };
		Student s22 = new Student("001", "zhangsan", arr);
		float[] arr1 = { 80, 80, 90 };
		Student s23 = new Student("001", "zhangsan", arr);
		int[] arr2 = { 80, 79, 90 };
		System.out.println(Min.min(arr2));
	}
}

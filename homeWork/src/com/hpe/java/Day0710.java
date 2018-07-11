package com.hpe.java;

import java.util.Scanner;

/**
 * 
 * @author chaoling
 * @date 2018年7月10日下午7:04:00
 * @Description
 */

public class Day0710 {
	
	public static void test1() {

		// 定义一个int[] a =｛4，2，0，-1，-8，23，9｝求数组元素的最大值、最小值、平均数、总和、数组的复制、反转
		int[] a = { 4, 2, 0, -1, -8, 23, 9 };
		int max = 0;
		int min = 0;
		double avg = 0;
		int sum = 0;

		for (int i = 0; i < a.length; i++) {

			if (max < a[i])
				max = a[i];

			if (min > a[i])
				min = a[i];

			sum += a[i];

		}

		avg = sum / a.length;

		System.out.println("最大值" + max);
		System.out.println("最小值" + min);
		System.out.println("平均数" + avg);
		System.out.println("总   和" + sum);

		int[] b = new int[a.length];

		System.out.println("数组的复制");

		for (int i = 0; i < a.length; i++) {
			
			b[i] = a[i];
			
			System.out.print(b[i] + " ");
			
		}
			
		System.out.println();
		System.out.println("数组的反转");

		int temp;
		//方式一
		//最前与最后交换，之后最前++，最后--，只要最前小于最后那么就接着循环
		for(int begin  = 0,end = a.length - 1;begin<end;begin ++,end--){
					
				temp = a[begin];
				a[begin] = a[end];
				a[end] = temp;
		}
		
		/*//方式二
		for(int i = 0; i < a.length/2; i++){
			
			//交换
			temp = a[i];
			a[i] = a[a.length -1-i];
			a[a.length -1-i] = temp;
			
		}*/

		

	}

	public static void test2() {

		// 数组元素的排序从键盘输入5个人的年龄，全部输入完后打印。
		Scanner sc = new Scanner(System.in);

		int arr[] = new int[5];
		int temp;

		for (int i = 0; i < 5; i++) {

			System.out.println("请输入第" + (i + 1) + "个人的年龄");

			arr[i] = sc.nextInt();

			// 插入排序
			for (int j = 0; j < i; j++) {

				if (arr[i] > arr[j]) {

					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;

				}

			}

		}

		System.out.println("排序后");

		for (int i = 0; i < 5; i++) {

			System.out.print(arr[i] + " ");

		}

	}

	public static void test3() {

		// 从键盘输入10个整数存入在一个数组中，计算所有元素之和及平均值，并找出最大值和最小值
		Scanner sc = new Scanner(System.in);
		double avg = 0.0;
		int[] arr = new int[10];

		for (int i = 0; i < 10; i++) {

			System.out.println("请输入第" + (i + 1) + "个数");

			arr[i] = sc.nextInt();

		}

		int max = arr[0];
		int min = arr[0];
		int sum = 0;

		for (int i = 0; i < 10; i++) {

			if (max < arr[i])
				max = arr[i];

			if (min > arr[i])
				min = arr[i];

			sum += arr[i];

		}

		avg = sum / 10;

		System.out.println("最大值" + max);
		System.out.println("最小值" + min);
		System.out.println("平均数" + avg);
		System.out.println("总   和" + sum);

	}

	public static void test4() {

		// 将数组{4,0,5,8,2,0,6,8,3}中的0去掉后返回一个新数组。
		int[] arr = { 4, 0, 5, 8, 2, 0, 6, 8, 3 };
		int count = 0;

		for (int i = 0; i < arr.length; i++) {

			// 遍历数组，计算数组元素中0的个数
			if (arr[i] == 0) {

				count++;

			}

		}

		//定义一个新数组，用于保存不为0的元素-->新数组的长度 == arr.length -count(0的个数)
		int[] arrNew = new int[arr.length-count];
		
		//将arr中非0的元素放到arrNew-->遍历arr,得到所有元素，如果元素不为0，才放到arrNew中
		for (int i = 0,j = 0; i < arr.length && j < arr.length - count; i++) {

			//如果arr[i]不为0，才放到arrNew中
			if (arr[i] != 0) {

				arrNew[j] = arr[i];
				j++;

			}
			System.out.println(arrNew[j]);

		}

	}

	public static void test5() {

		// 现在给出两个数组，数组A：“1，7，9，11，13，15，17，19；数组B：“2，4，6，8，10”两个数组合并为数组C，按升序排列

		int[] a = { 1, 7, 9, 11, 13, 15, 17, 19 };
		int[] b = { 2, 4, 6, 8, 10 };

		int[] c = new int[a.length + b.length];
		
		int j ,k ;
		j = k =0;
		
		//归并法实现
		for(int i : c){
			
			if(j < a.length  && k < b.length){
				
				if(a[j] < b[k]){
					
					i = a[j];
					j++;
					
				}
				else {
					
					i = b[k];
					k++;
					
				}	
				
			}
			else if(j < a.length && k == b.length  ){
				
				i = a[j];
				j++;
				
			}
			else{
				
				i = b[k];
				k++;
				
			}
			
			System.out.println(i);
			
		}
		
	}

	public static void test6() {

		// 输出1 1 2 3 5 8 13……这样的Fibonacci数列，输出该数列的前20个数字
		int[] arr = new int[20];

		System.out.println("前20位的Fibonacci数列");

		for (int i = 0; i < 20; i++) {

			if (i < 2)
				arr[i] = 1;
			else
				arr[i] = arr[i - 1] + arr[i - 2];

			System.out.print(arr[i] + " ");

		}

	}

	public static void test7() {

		/*
		 * 歌手打分：在歌唱比赛中，共有10位评委进行打分 在计算歌手得分时，去掉一个最高分，去掉一个最低分，
		 * 然后剩余的8位评委的分数进行平均，就是该选手的最终得分。 输入每个评委的评分，求某选手的得分。
		 */
		// 方式一
		/*
		 * int sum = 0; 
		 * double avg = 0.0; 
		 * int max = 0; 
		 * int min = -1; 
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * for(int i = 0; i < 10; i++){
		 * 
		 * 		System.out.println("请输入得分："); 
		 * 
		 * 		int score = sc.nextInt();
		 * 
		 * 		if(i ==0){ 
		 * 			max = score; 
		 * 			min = score; 
		 * 		} 
		 * 
		 * 		if(max < score ) 
		 * 			max = score;
		 * 
		 * 		if(min > score) 
		 * 			min = score;
		 * 
		 * 		sum += score;
		 * 
		 * } 
		 * 
		 * sum = sum - max - min;
		 * avg = sum / 8.0;
		 * 
		 * System.out.println("选手的得分为：" + avg);
		 */

		// 方式二
		int sum = 0;
		double avg;
		int[] score = new int[10];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {

			System.out.println("请输入得分：");
			
			score[i] = sc.nextInt();

		}

		int max = score[0];
		int min = score[0];

		for (int i = 0; i < score.length; i++) {
			
			if (i == 0) {
				
				max = score[i];
				min = score[i];
				
			}
			
			if (max < score[i])
				max = score[i];

			if (min > score[i])
				min = score[i];

			sum += score[i];

		}
		
		sum = sum - max - min;
		avg = sum / 8.0;

		System.out.println("选手的得分为：" + avg);

	}

	public static void test8() {
		/*
		判断一个数组{1,2,3,1,0}中是否存在相同的元素，
		如果存在相同的元素则输出“重复”，否则输出“不重复”
		*/
		int[] arr = { 1, 2, 3, 1, 0 };
		boolean flag = false;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < i; j++) {

				if (arr[i] == arr[j]) {

					flag = true;
					break;

				}

			}

		}

		if (flag)
			System.out.println("重复");
		else
			System.out.println("不重复");

	}

	public static void test9() {

		//将十进制整数35转换为二进制数。
		int[] arr = new int[8];
		int num = 35;

		//将数组的长度定义为一个字节的长度（8位）
		for (int i = 7; i > 0; i--) {

			arr[i] = num % 2;
			num /= 2;

		}

		//输出时将前几个0跳过，不输出
		boolean flag = false;

		for (int i = 0; i < 8; i++) {

			if (arr[i] != 0)
				flag = true;

			if (flag)
				System.out.print(arr[i]);

		}

	}

}

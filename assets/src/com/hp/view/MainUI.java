package com.hp.view;

import java.util.Scanner;

/**
 * @Description:程序主界面
 * @author chaoling
 * @date 2018年7月30日
 */
public class MainUI {

	/**
	 * @Description: 程序入口
	 */
	public static void main(String[] args) {
		
		menu();
		Scanner sc = new Scanner(System.in);
		
		while(true){
			
			String choice = sc.nextLine();
			
			switch (choice) {
			case "1":
				new AdminUI().admin();
				break;

			case "2":
				
				break;
			
			case "0":
				exit();
				break;
			default:
				System.out.println("选择错误，请重新选择!");
				break;
			}
		}
		
	}
	
	
	
	
	/**
	 * @Description: 主菜单显示    
	 */
	public static void menu(){
		
		System.out.println("------------个人资产管理系统------------");
		System.out.println("***************1.管理员***************");
		System.out.println("****************2.顾客***************");
		System.out.println("****************0.退出***************");
		System.out.println("------------------------------------");
		System.out.print("请选择登录方式:");
		
	}
	
	/**
	 * @Description: 退出显示
	 */
	public static void exit(){
		
		System.out.println("谢谢使用");
		System.exit(0);
	}
}
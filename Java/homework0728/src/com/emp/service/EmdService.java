package com.emp.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.emp.po.Employee;

public class EmdService {
	
	List<Employee> emp = new ArrayList<>();
	
	/**
	 * @Description: 添加操作 将employee对象添加到emp中
	 * @param employee
	 * @return  boolean   
	 * @throws
	 */
	public boolean addEmployee(Employee employee) {

		return emp.add(employee);
	}

	/**
	 * 
	 * @Description: 删除操作
	 * @param name
	 * @return  int   
	 * @throws
	 */
	public int delEmployee(String name) {

		//获取当前姓名的索引
		int index = isExist(name);
		//判断当前name是否存在，不存在返回 -1
		if(index == -1)
			return -1;
		//删除操作
		Employee res = emp.remove(index);
		
		if(res != null)
			return 1;
		return 0;
	}

	/**
	 * @Description: 修改操作
	 * @param employee
	 * @param index
	 * @return boolean    
	 * @throws
	 */
	public boolean updateEmployee(Employee employee, int index) {

		//获取原来的对象
		Employee e = emp.get(index);
		Employee set = emp.set(index, employee);
		
		if(e.equals(set))
			return true;
		else
			return false;
	}

	/**
	 * @Description: 获取操作
	 * @param index
	 * @return  Employee   
	 * @throws
	 */
	public Employee queryEmployee(int index) {

		return emp.get(index);

	}
	
	/**
	 * @Description: 根据姓名判断是否存在 存在则返回对应的索引，不存在返回-1
	 * @param @param name  
	 * @return @param name
	 * @throws
	 */
	public int isExist(String name) {

		for(Employee employee : emp)
			if(employee.getName().equals(name))
				return emp.indexOf(employee);
		
		return -1;
	}

	/**
	 * @Description: 初始化，即读入数据   
	 * @param pathname     
	 * @throws
	 */
	public void init(String pathname) {
		
		BufferedReader br = null;
		File file = new File(pathname);
		//判断文件是否存在，不存在就创建
		try {
			if(!file.exists())
				file.createNewFile();
			
			br = new BufferedReader(new FileReader(file));
			String line = null;
			
			while((line = br.readLine())!= null){
				
				String[] arr = line.split(",");
				Employee employee = new Employee(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), Double.parseDouble(arr[4]));
				
				emp.add(employee);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	/**
	 * 
	 * @Description: 写入操作
	 * @param pathname     
	 * @throws
	 */
	public void exit(String pathname) {
		
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(pathname));
			
			Iterator<Employee> iterator = emp.iterator();
			
			while(iterator.hasNext()){
				bw.write(iterator.next().toString());
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw !=null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}

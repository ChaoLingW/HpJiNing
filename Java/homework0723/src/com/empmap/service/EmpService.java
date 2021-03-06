package com.empmap.service;
/**
 * @Description: 业务处理
 * @author chaoling
 * @date 2018年7月28日下午3:16:17
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.empmap.po.Employee;

public class EmpService {
	
	Map<String, Employee> emp = new HashMap<>();
	
	/**
	 * @Description: 添加操作 将employee对象添加到emp中
	 * @param employee
	 * @return  boolean   
	 * @throws
	 */
	public boolean addEmployee(Employee employee) {

		if(employee!= null) {
			emp.put(employee.getName(), employee);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @Description: 删除操作
	 * @param name
	 * @return  boolean  
	 * @throws
	 */
	public boolean delEmployee(String name) {
		
		Employee res = emp.remove(name);
		
		if(res != null)
			return true;
		return false;
	}

	/**
	 * @return 
	 * @Description: 修改操作
	 * @param employee
	 * @param name
	 * @return void    
	 * @throws
	 */
	public void updateEmployee(Employee employee, String name) {

		//若不修改姓名则直接设置，否则就先移除再添加
		if(name.equals(employee.getName()))
			emp.put(name, employee);
		else{
			//移除原来的对象
			emp.remove(name);
			//添加新的对象
			emp.put(employee.getName(), employee);
		}
	}

	/**
	 * @Description: 获取操作
	 * @param String
	 * @return  Employee   
	 * @throws
	 */
	public Employee queryEmployee(String name) {

		return emp.get(name);

	}
	
	/**
	 * @Description: 根据姓名判断是否存在 存在则返回true 不存在返回false
	 * @param @param name  
	 * @return @param boolean
	 * @throws
	 */
	public boolean isExist(String name) {

		return emp.containsKey(name);
	}

	/**
	 * 
	 * @Description:应对修改时修改的不是修改前的名字 
	 * @param name
	 * @return boolean   
	 * @throws
	 */
	public boolean isUpdate(String newName,String oldName){
		//如果是修改前的名字，则返回true
		if(newName.equals(oldName))
			return true;
		else{
			//如果是新名字，并且不存在 true
			if(emp.containsKey(newName))
				return false;
			else
				//存在同名的情况 不是本身
				return true;
		}
	}
	
}


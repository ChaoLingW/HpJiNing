package com.telmap.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.telmap.po.Telephone;
/**
 * @Description: 电话本管理的业务类
 * @author chaoling
 * @date 2018年7月28日下午4:45:53
 */
public class TelService {

	Map<String, Telephone> tels = new HashMap<>();
	
	// 添加电话本业务
	// 参数：Telephone，代表的电话本
	// 返回值：true  添加成功  false 添加失败 
	public boolean addTel(Telephone telephone) {

		if(telephone!=null){
			tels.put(telephone.getName(), telephone);
			return true;
		}
		else
			return false;
	}

	// 根据姓名删除电话本
	// 参数：String，代表的电话本
	// 返回值： true 删除成功
	public boolean deleteTelByName(String name) {
		
		tels.remove(name);
		return true;
	}

	// 根据姓名更新电话本
	// 参数 Telephone int
	// 返回值 boolean
	public boolean updateTel(Telephone telephone, String name) {

		if(!telephone.equals(name))
			tels.remove(name);
			
		tels.put(telephone.getName(), telephone);
		return true;

	}

	// 查询所有电话本业务
	// 参数：无参
	// 返回值：List<Telephone>
	public Map<String,Telephone> selectAllTel() {
		
		return tels;
	}

	// 根据姓名查询
	// 参数：String
	// 返回值：Telephone
	public Telephone selectTelByName(String name) {

		return tels.get(name);
	}

	//判断name是否存在
	public boolean isExist(String name) {

		return tels.containsKey(name);
	}

	//修改时新名字只能有一个就是旧名字或者不存在
	public boolean isUpdate(String newName,String oldName){
		//如果是修改前的名字，则返回true
		if(newName.equals(oldName))
			return true;
		else{
			//如果是新名字，并且不存在 true
			if(tels.containsKey(newName))
				return false;
			else
				//存在同名的情况 不是本身
				return true;
		}
	}
}

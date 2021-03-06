package com.hpe.service;

import java.util.List;

import com.hpe.dao.UserDao;
import com.hpe.po.User;

/**
 * @Description: User管理的业务类
 * @author chaoling
 * @date 2018年7月30日下午5:06:49
 */
public class UserService {
	
	UserDao userDao = new UserDao();
	
	/**
	 * @Description: 添加用户的业务
	 * @param user
	 * @return 1 -1 0    
	 * @throws
	 */
	public int addUser(User user){
		
		//判断此用户名的用户是否存在 -->查询-->根据姓名查询
		if(userDao.selectByName(user.getUserName()) != null)
			return -1;
		return userDao.addUser(user);
	}

	/**
	 * @Description: 根据用户名删除
	 * @param name
	 * @return -1 0 1    
	 * @throws
	 */
	public int  deleteUserByName(String name){
		
		return (userDao.selectByName(name)== null)? -1 : userDao.deleteUserByName(name);	
	}
	
	/**
	 * @Description: 根据姓名修改，不改变姓名
	 * @param user
	 * @return     
	 * @throws
	 */
	public int updateByName(User user){
		
		return userDao.updateByname(user);
	}
	
	/**
	 * @Description: 查询所有用户
	 * @return List<user>    
	 * @throws
	 */
	public List<User> seleteAllUser(){
		return userDao.selectAll();
		
	}
	
	/**
	 * @Description: 根据姓名查询
	 * @param name
	 * @return     
	 * @throws
	 */
	public User seleteByName(String name){
		
		return userDao.selectByName(name);
	}
}

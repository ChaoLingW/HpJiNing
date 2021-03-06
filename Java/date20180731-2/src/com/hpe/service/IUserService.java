package com.hpe.service;

import java.util.List;

import com.hpe.po.User;

public interface IUserService {

	/**
	 * @Description: 添加用户的业务
	 * @param user
	 * @return 1 -1 0    
	 * @throws
	 */
	public int addUser(User user);

	/**
	 * @Description: 根据用户名删除
	 * @param name
	 * @return -1 0 1    
	 * @throws
	 */
	public int  deleteUserByName(String name);
	
	/**
	 * @Description: 根据姓名修改，不改变姓名
	 * @param user
	 * @return     
	 * @throws
	 */
	public int updateByName(User user);
	
	/**
	 * @Description: 查询所有用户
	 * @return List<user>    
	 * @throws
	 */
	public List<User> seleteAllUser();
	
	/**
	 * @Description: 根据姓名查询
	 * @param name
	 * @return     
	 * @throws
	 */
	public User seleteByName(String name);
}

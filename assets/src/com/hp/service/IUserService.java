package com.hp.service;

import java.util.List;

import com.hp.po.Asset;
import com.hp.po.User;

public interface IUserService {
	
	/**
	 * @Description: 普通用户登录
	 * @param user
	 * @return -1 用户名不存在 0 密码错误 1 成功  
	 * @throws
	 */
	int loginUser(User user);
	
	/**
	 * @Description: 用户注册
	 * @param user
	 * @return -1 该用户民已存在  >0 注册成功  0 注册失败  
	 * @throws
	 */
	int registerUser(User user);
	
	/**
	 * @Description: 判断此用户名是否存在
	 * @param userName
	 * @return true 存在 false 不存在  
	 * @throws
	 */
	boolean isExitsByUserName(String userName);

}

package com.hp.service;

import java.util.List;

import com.hp.po.Admin;
import com.hp.po.Bank;
import com.hp.po.User;

/**
 * @Description:Admin业务处理接口
 * @author chaoling
 * @date 2018年7月31日
 */
public interface IAdminService {

	/**
	 * @Description: 管理员登录
	 * @param user
	 * @return  -1 该用户不存在  0 密码错误 -1 登录成功
	 * @throws
	 */
	int loginAdmin(Admin admin);
	/**
	 * @Description: 查询所有的普通用户
	 * @return list  
	 * @throws
	 */
	List<User> selectAllUser();
	
}
package com.hp.service.impl;

import java.util.List;

import com.hp.dao.IAdminDao;
import com.hp.dao.impl.AdminDao;
import com.hp.po.Admin;
import com.hp.po.User;
import com.hp.service.IAdminService;

/**
 * @Description:对管理员的业务操作类，实现IAdminService接口
 * @author chaoling
 * @date 2018年8月2日
 */
public class AdminService implements IAdminService {

	// 需要的dao成对象私有化为属性
	private IAdminDao adminDao = new AdminDao();

	@Override
	public int loginAdmin(Admin admin) {

		// 获取传进来的adminName的记录
		Admin res = adminDao.selectByAdminName(admin.getAdminName());
		// 为null不存在该用户名
		if (res == null)
			return -1;
		// 比较相同用户名的密码是否相同,相同返回对应的adminId
		if (admin.getAdminPassword().equals(res.getAdminPassword()))
			return res.getAdminId();
		return 0;
	}

}

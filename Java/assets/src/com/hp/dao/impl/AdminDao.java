package com.hp.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.hp.dao.IAdminDao;
import com.hp.po.Admin;
import com.hp.util.DBUtil;

/**
 * @Description:对admin表的操作，实现IAdminDao接口
 * @author chaoling
 * @date 2018年8月1日
 */

public class AdminDao implements IAdminDao {

	@Override
	public Admin selectByAdminName(String adminName) {

		// 根据用户名查询
		String sql = "select * from admin where adminName = ?";

		return DBUtil.query(sql, new BeanHandler<>(Admin.class), adminName);
	}

}

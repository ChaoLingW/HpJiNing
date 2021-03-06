package com.teljdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @Description:数据源操作接口
 * @author chaoling
 * @date 2018年7月31日
 */
public class DBDataScoure {

	private static DataSource dataSource;
	
	/**
	 * 初始化dataSource
	 */
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	/**
	 * @Description: 获得数据源
	 * @return dataSource 数据源  
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
}

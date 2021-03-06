package com.hpe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hpe.dao.IUserDao;
import com.hpe.po.User;
import com.hpe.util.JdbcUtil;

/**
 * @Description: 对user表操作的类
 * @author chaoling
 * @date 2018年7月30日下午2:26:21
 */
public class UserDaoImpl implements IUserDao{

	/**
	 * @Description: 添加一条记录
	 * @param user
	 * @return row    
	 * @throws SQLException
	 */
	public int addUser(User user){
		
		//使用dbutils完成jdbc操作
		
		//1.创建QueryRunner
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());;
		//2.写sql
		String sql = "insert into user(username,password ,realname,age) values(?,?,?,?)";
		Object[] params = {user.getUserName(),user.getPassword(),user.getRealName(),user.getAge()};
		
		//3.update方法用于执行增删改的sql语句，返回受影响的行数，带Connection参数的方法与事物相关
		//1.sql语句 2.占位符的数组
		int count = 0;
		
		try {
			count = qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	/**
	 * @Description: 根据姓名删除
	 * @param name
	 * @return row    
	 * @throws SQLException
	 */
	public int deleteUserByName(String name){

		String sql = "delete from user where username = ?";
		int row = 0;
		
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		Object[] params = {name};
		
		try {
			row = qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	/**
	 * @Description: 根据姓名修改
	 * @param user
	 * @return row    
	 * @throws SQLException
	 */
	public int updateByName(User user){
		
		int row = 0;
		String sql = "update user set password = ?, realname = ?,age = ? where username = ?";
		
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		
		Object[] params = {user.getPassword(),user.getRealName(),user.getAge(),user.getUserName()};
		
		try {
			row = qr.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	/**
	 * @Description: 查询所有
	 * @return users
	 * @throws SQLException
	 */
	public List<User> selectAll(){
		
		List<User> users = null;
		String sql = "select * from user";
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		
		try {

			users = qr.query(sql, new BeanListHandler<>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * @Description: 根据姓名查询
	 * @param name
	 * @return user    
	 * @throws SQLException
	 */
	public User selectByName(String name){
		
		User user = null;
		ResultSet resultSet = null;
		//1.sql
		String sql = "select * from user where username = ?";
		//2.创建QueryRunner
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		
		//3.占位符数组
		Object[] params = {name};
		
		//4.调用query方法
		try {
			user = qr.query(sql, new BeanHandler<>(User.class), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}

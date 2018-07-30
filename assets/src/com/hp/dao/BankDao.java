package com.hp.dao;

import java.util.List;

import com.hp.po.Bank;

/**
 * @Description:对bank表操作的接口
 * @author chaoling
 * @date 2018年7月30日
 */
public interface BankDao {
	
	/**
	 * @Description: 对bank表执行插入操作
	 * @param bank
	 * @return true 添加成功; false 添加失败  
	 * @throws SQLException
	 */
	public boolean add(Bank bank);
	
	/**
	 * @Description: 对bank表执行删除操作
	 * @param bank
	 * @return true 删除成功; false 删除失败   
	 * @throws SQLException
	 */
	public boolean delete(Bank bank);
	
	/**
	 * @Description: 对bank表执行更新/修改操作
	 * @param bank
	 * @return true 更新成功; false 更新失败
	 * @throws SQLException
	 */
	public boolean update(Bank bank);
	
	/**
	 * @Description: 查询bank表中的所有记录
	 * @return List<bank> 存储所有的记录，为空时且size()为0时表示表为空  
	 * @throws SQLException
	 */
	public List<Bank> selectAll();
	
	/**
	 * @Description: 根据id查询是否存在该id的记录
	 * @param bankId
	 * @return true 存在; false 不存在   
	 * @throws SQLException
	 */
	public boolean selectById(int bankId);

	/**
	 * @Description: 根据name查询是否存在该名称
	 * @param name
	 * @return true 存在; false 不存在   
	 * @throws SQLException
	 */
	public Bank selectByName(String name);

}

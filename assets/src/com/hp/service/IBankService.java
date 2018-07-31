package com.hp.service;

import java.util.List;

import com.hp.po.Bank;

/**
 * @Description:银行业务的接口类
 * @author chaoling
 * @date 2018年7月31日
 */
public interface IBankService {

	/**
	 * @Description: 添加一条银行记录
	 * @param bank
	 * @return ture 添加成功
	 * @throws SQLException
	 */
	boolean addBank(Bank bank);

	/**
	 * @Description: 根据银行id删除改银行
	 * @param bankId
	 * @return true 删除成功  false 删除失败
	 * @throws SQLException
	 */
	boolean deleteBankByBankId(int bankId);
	
	/**
	 * @Description: 对bank表执行更新/修改操作
	 * @param bank
	 * @return true 更新成功；false更新失败
	 * @throws SQLException
	 */
	boolean updateBankByBankId(Bank bank);
	
	/**
	 * @Description: 查询bank表中的所有记录
	 * @return banks 存储所有的记录，为空时且size()为0时表示表为空  
	 * @throws SQLException
	 */
	public List<Bank> selectAll();
	
	/**
	 * @Description: 根据id查询是否存在该id的记录
	 * @param bankId
	 * @return true 存在   false 不存在
	 * @throws SQLException
	 */
	public boolean selectByBankId(int bankId);

	/**
	 * @Description: 根据name查询是否存在该名称
	 * @param name
	 * @return bank 存在就返回这条记录，否则返回null   
	 * @throws SQLException
	 */
	Bank selectByName(String name);

}

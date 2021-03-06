package com.hp.dao;

import java.util.List;

import com.hp.po.Bank;

/**
 * @Description:对bank表操作的接口
 * @author chaoling
 * @date 2018年7月30日
 */
public interface IBankDao {

	/**
	 * @Description: 添加一条记录
	 * @param bank
	 * @return >0 添加成功
	 */
	public int addBank(Bank bank);

	/**
	 * @Description: 根据银行id删除改银行
	 * @param bankId
	 * @return >0 删除成功
	 */
	public int deleteBankByBankId(int bankId);

	/**
	 * @Description: 对bank表执行更新/修改操作
	 * @param bank
	 * @return >0 更新成功
	 */
	public int updateBankByBankId(Bank bank);

	/**
	 * @Description: 查询bank表中的所有记录
	 * @return banks 存储所有的记录，为空时且size()为0时表示表为空
	 */
	public List<Bank> selectAll();

	/**
	 * @Description: 根据id查询是否存在该id的记录
	 * @param bankId
	 * @return >0 存在
	 */
	public Bank selectByBankId(int bankId);

	/**
	 * @Description: 根据name查询是否存在该名称
	 * @param name
	 * @return bank 存在返回这条记录，不存在返回null
	 */
	public Bank selectByBankName(String bankName);

}

package com.hp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hp.dao.IAssetDao;
import com.hp.dao.IBankDao;
import com.hp.dao.impl.AssetDao;
import com.hp.dao.impl.BankDao;
import com.hp.po.Bank;
import com.hp.service.IBankService;
import com.hp.util.DBUtil;

/**
 * @Description:银行业务的操作类，实现IBankService
 * @author chaoling
 * @date 2018年8月1日
 */
public class BankService implements IBankService {

	private IBankDao bankDao = new BankDao();
	private IAssetDao assetDao = new AssetDao();

	@Override
	public int addBank(Bank bank) {
		// 查询待添加的银行是否存在
		Bank resBank = bankDao.selectByBankName(bank.getBankName());
		// 存在，返回-1
		if (resBank != null)
			return -1;
		// 执行更新，并接收返回值
		int res = bankDao.addBank(bank);
		if (res > 0)
			// 更新成功
			return 1;
		// 更新失败
		return 0;
	}

	@Override
	public boolean deleteBankByBankId(int bankId) {

		try {
			// 开启事务
			DBUtil.beginTranscation();
			// 删除该bankId对应的资产
			assetDao.deleteByBankId(bankId);
			// 删除对应的银行
			bankDao.deleteBankByBankId(bankId);
			// 提交事务
			DBUtil.commitTransaction();
			// 返回 更新成功
			return true;
		} catch (SQLException e) {
			try {
				// 出现异常，回退
				DBUtil.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		// 更新失败
		return false;
	}

	@Override
	public int updateBankByBankId(Bank bank) {
		// 查询待修改的bank
		Bank bankRes = bankDao.selectByBankName(bank.getBankName());
		// 信息已存在不可修改
		if (bankRes != null)
			return -1;
		// 执行更新并接收返回值
		int res = bankDao.updateBankByBankId(bank);
		if (res > 0)
			// 更新成功
			return 1;
		// 更新失败
		return 0;
	}

	@Override
	public List<Bank> selectAll() {
		// 查询所有的银行记录
		List<Bank> res = bankDao.selectAll();

		if (res != null && res.size() != 0)
			return res;
		return null;
	}

	@Override
	public Bank selectByBankId(int bankId) {
		// 根据bankId判断是否存在，存在返回对应的记录，不存在返回null
		Bank bank = bankDao.selectByBankId(bankId);
		if (bank != null)
			return bank;
		return null;
	}

	@Override
	public Bank selectByName(String bankName) {
		// 根据银行姓名判断是否存在，存在返回对应的记录，不存在返回null
		Bank bank = bankDao.selectByBankName(bankName);
		if (bank != null)
			return bank;
		return null;
	}

}

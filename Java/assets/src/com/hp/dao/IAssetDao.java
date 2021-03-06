package com.hp.dao;

import java.util.List;

import com.hp.po.Asset;
import com.hp.po.Bank;
import com.hp.po.User;
import com.hp.vo.AssetInfo;

/**
 * @Description:对asset表操作的接口
 * @author chaoling
 * @date 2018年7月30日
 */
public interface IAssetDao {

	/**
	 * @Description: 查询该user下的所有asset信息 (多表查询)
	 * @param userId
	 * @return List<AssetInfo> 若为null且size()为0,则不存在
	 * @throws SQLException
	 */
	public List<AssetInfo> selectAllAssetByUserId(int userId);

	/**
	 * @Description: 添加资产
	 * @param asset
	 * @return >0 添加成功，0 添加失败
	 */
	public int addAsset(Asset asset);

	/**
	 * @Description: 修改资产 (提取/存入)
	 * @param asset
	 * @return >0 修改成功
	 */
	public int updateAsset(Asset asset);

	/**
	 * @Description: 查询该用户下的总资产
	 * @param userId
	 * @return 返回总资产，若为-1.0 则说明无资产
	 */
	public double selectSumAsset(int userId);

	/**
	 * @Description: 查询该cardNum是否存在
	 * @param asset
	 * @return >0 存在
	 */
	public int selectCardNum(Asset asset);

	/**
	 * @Description: 根据银行id删除资产
	 * @param bankId
	 * @return >0 删除成功
	 */
	public int deleteByBankId(int bankId);

	/**
	 * @Description: 判断是否存在该资产
	 * @param asset
	 * @return 存在返回这条资产的记录 不存在 为null
	 */
	public Asset selectOfTakeOrSave(Asset asset);

}

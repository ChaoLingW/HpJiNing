package com.hp.dao;

import java.util.List;

import com.hp.po.Asset;
import com.hp.po.User;

/**
 * @Description:对asset表操作的接口
 * @author chaoling
 * @date 2018年7月30日
 */
public interface AssetDao {
	
	/**
	 * @Description: 查询该user下的所有asset表中的信息
	 * @param user
	 * @return List<Asset> 若为null且size()为0,则不存在  
	 * @throws SQLException
	 */
	public List<Asset> selectAll(User user);
	
	/**
	 * @Description: 查询该cardNum是否存在
	 * @param cardNum
	 * @return true 存在，false不存在  
	 * @throws SQLException
	 */
	public boolean selectByCardNum(String cardNum);

	/**
	 * @Description: 添加资产
	 * @param asset
	 * @param user
	 * @return true 添加成功，false 添加失败  
	 * @throws SQLException
	 */
	public boolean add(Asset asset, User user);
	
	/**
	 * @Description: 判断该用户是否有该资产
	 * @param bankId
	 * @param CardNum
	 * @param userName
	 * @return asset为null则不存在
	 * @throws SQLException
	 */
	public Asset updateBefore(int bankId, String CardNum,String userName);
	
	/**
	 * @Description: 修改资产 (提取/存入)
	 * @param asset
	 * @return ture 修改成功，false 修改失败  
	 * @throws SQLException
	 */
	public boolean updateAsset(Asset asset);
	
	/**
	 * @Description: 查询该用户下的总资产
	 * @param user
	 * @return 返回总资产，若为-1 则说明无资产  
	 * @throws SQLException
	 */
	public double selectSumAsset(User user);
	
}

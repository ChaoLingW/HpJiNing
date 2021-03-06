package com.hp.vo;

import java.util.Date;

/**
 * @Description:用于多表查询
 * @author chaoling
 * @date 2018年8月2日
 */
public class AssetInfo {
	
	private int userId;
	private String userName;
	private int bankId;
	private String bankName;
	private int cardNum;
	private double cardMoney;
	private Date createDate;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getBankId() {
		return bankId;
	}
	
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public int getCardNum() {
		return cardNum;
	}
	
	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	
	public double getCardMoney() {
		return cardMoney;
	}
	
	public void setCardMoney(double cardMoney) {
		this.cardMoney = cardMoney;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreatDate(Date creatDate) {
		this.createDate = creatDate;
	}
	
	public AssetInfo(int userId, String userName, int bankId, String bankName, int cardNum, double cardMoney,
			Date creatDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.bankId = bankId;
		this.bankName = bankName;
		this.cardNum = cardNum;
		this.cardMoney = cardMoney;
		this.createDate = creatDate;
	}
	
	public AssetInfo() {
		super();
	}
	
	@Override
	public String toString() {
		return "AssetInfo [userId=" + userId + ", userName=" + userName + ", bankId=" + bankId + ", bankName="
				+ bankName + ", cardNum=" + cardNum + ", cardMoney=" + cardMoney + ", createDate=" + createDate + "]";
	}

}

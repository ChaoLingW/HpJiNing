package com.hp.po;

import java.util.Date;

/**
 * @Description: asset表对应的实体类
 * @author chaoling
 * @date 2018年7月30日下午4:54:11
 */
public class Asset {

	private int bankId;
	private int cardNum;
	private double carMoney;
	private Date careteDate; 
	private int userId;
	
	public int getBankId() {
		return bankId;
	}
	
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	
	public int getCardNum() {
		return cardNum;
	}
	
	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	
	public double getCarMoney() {
		return carMoney;
	}
	
	public void setCarMoney(double carMoney) {
		this.carMoney = carMoney;
	}
	
	public Date getCareteDate() {
		return careteDate;
	}
	
	public void setCareteDate(Date careteDate) {
		this.careteDate = careteDate;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Asset(int bankId, int cardNum, double carMoney, Date careteDate, int userId) {
		super();
		this.bankId = bankId;
		this.cardNum = cardNum;
		this.carMoney = carMoney;
		this.careteDate = careteDate;
		this.userId = userId;
	}

	public Asset() {
		super();
	}

	@Override
	public String toString() {
		return "Asset [bankId=" + bankId + ", cardNum=" + cardNum + ", carMoney=" + carMoney + ", careteDate="
				+ careteDate + ", userId=" + userId + "]";
	}
}
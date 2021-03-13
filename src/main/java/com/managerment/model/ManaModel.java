package com.managerment.model;

public class ManaModel {
	private int oderId;
	private String content;
	private float money;
	private String typePay;
	private String bank;
	private String ipAddr;
	private String status;
	private String createDate;
	private String language;
	
	public ManaModel() {
	}
	
	public ManaModel(int orderID, String content, float money, String typePay, String bank, String status, String ipAddr, String cateateDate, String language) {
		this.oderId = orderID;
  		this.content = content;
		this.bank = bank; 
		this.money = money;
		this.status = status;
		this.ipAddr = ipAddr;
		this.createDate = cateateDate;
		this.typePay = typePay;
		this.language = language;
	}

	public int getOderId() {
		return oderId;
	}

	public void setOderId(int oderId) {
		this.oderId = oderId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public String getTypePay() {
		return typePay;
	}

	public void setTypePay(String typePay) {
		this.typePay = typePay;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}

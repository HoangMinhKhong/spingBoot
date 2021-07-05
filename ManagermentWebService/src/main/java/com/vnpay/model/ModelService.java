package com.vnpay.model;

import java.sql.Date;

public class ModelService {
	private int ORDER_ID;
	private String CONTENT;
	private float MONEY;
	private String TYPE_PAY;
	private String BANK;
	private String IP_ADDR;
	private String STATUS;
	private Date CREATE_DATE;
	private String LANGUAGE;
	public int getOrderId() {
		return ORDER_ID;
	}
	public void setOrderId(int orderId) {
		this.ORDER_ID = orderId;
	}
	public String getContent() {
		return CONTENT;
	}
	public void setContent(String content) {
		this.CONTENT = content;
	}
	public float getMoney() {
		return MONEY;
	}
	public void setMoney(float money) {
		this.MONEY = money;
	}
	public String getTypePay() {
		return TYPE_PAY;
	}
	public void setTypePay(String typePay) {
		this.TYPE_PAY = typePay;
	}
	public String getBank() {
		return BANK;
	}
	public void setBank(String bank) {
		this.BANK = bank;
	}
	public String getIpAddr() {
		return IP_ADDR;
	}
	public void setIpAddr(String ipAddr) {
		this.IP_ADDR = ipAddr;
	}
	public String getStatus() {
		return STATUS;
	}
	public void setStatus(String status) {
		this.STATUS = status;
	}
	public Date getCreateDate() {
		return CREATE_DATE;
	}
	public void setCreateDate(Date date) {
		this.CREATE_DATE = date;
	}
	public String getLanguage() {
		return LANGUAGE;
	}
	public void setLanguage(String language) {
		this.LANGUAGE = language;
	}
}

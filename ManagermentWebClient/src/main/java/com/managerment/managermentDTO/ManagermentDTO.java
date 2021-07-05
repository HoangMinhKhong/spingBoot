package com.managerment.managermentDTO;

public class ManagermentDTO {
	private Long orderId;
	private String content;
	private Float money;
	private String typePay;
	private String bank;
	private String ipAddr;
	private String status;
	private String createDate;
	private String language;
	
	public ManagermentDTO() {
	}
	
	public ManagermentDTO(Long orderID, String content, Float money, String typePay, String bank, String status, String ipAddr, String cateateDate, String language) {
		this.orderId = orderID;
  		this.content = content;
		this.bank = bank; 
		this.money = money;
		this.status = status;
		this.ipAddr = ipAddr;
		this.createDate = cateateDate;
		this.typePay = typePay;
		this.language = language;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Float getMoney() {
		return money;
	}

	public void setMoney(Float money) {
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

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

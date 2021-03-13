package com.managerment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ORDER_HOANGKM")
public class Order {
	@Id
    @GeneratedValue
    @Column(name = "ORDER_ID", nullable = false)
    private int orderId;
 
    @Column(name = "CONTENT", length = 200)
    private String content;
 
    @Column(name = "MONEY")
    private float money;
    

    @Column(name = "STATUS", length = 100)
    private String status;
    

    @Column(name = "TYLE_PAY", length = 100)
    private String typePay;
    

    @Column(name = "BANK", length = 100)
    private String bank;
    

    @Column(name = "IP_ADDR")
    private String ipAddr;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column(name = "CREATE_DATE")
    private String createDate;
    
    @Column(name = "LANGUAGE", length = 100)
    private String language;
 
    public int getOrderId() {
        return orderId;
    }
 
    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
 
    public void setMoney(Long money) {
        this.money = money;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String gettylePay() {
		return typePay;
	}

	public void settylePay(String typePay) {
		this.typePay = typePay;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getIpAddress() {
		return ipAddr;
	}

	public void setIpAddress(String ip) {
		this.ipAddr = ip;
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

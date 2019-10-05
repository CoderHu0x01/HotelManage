package com.scme.familyhotel.pojo;

import java.util.Date;

/**
 * 
 * 这是结账账单实体类
 *
 */
public class Bill {
	// 账单编号
	private String billNo;
	// 消费金额
	private Double expendPrice;
	// 消费时间
	private Date expendTime;
	// 记账人
	private String tallyPeople;

	// 折扣
	private int rebate;

	// 宾客编号
	private int guestNo;

	// 结账备注
	private String billRemark;

	public int getGuestNo() {
		return guestNo;
	}

	public void setGuestNo(int guestNo) {
		this.guestNo = guestNo;
	}

	public Bill() {
		super();
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Double getExpendPrice() {
		return expendPrice;
	}

	public void setExpendPrice(Double expendPrice) {
		this.expendPrice = expendPrice;
	}

	public Date getExpendTime() {
		return expendTime;
	}

	public void setExpendTime(Date expendTime) {
		this.expendTime = expendTime;
	}

	public String getTallyPeople() {
		return tallyPeople;
	}

	public void setTallyPeople(String tallyPeople) {
		this.tallyPeople = tallyPeople;
	}

	public int getRebate() {
		return rebate;
	}

	public void setRebate(int rebate) {
		this.rebate = rebate;
	}

	public String getBillRemark() {
		return billRemark;
	}

	public void setBillRemark(String billRemark) {
		this.billRemark = billRemark;
	}

}

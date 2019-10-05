package com.scme.familyhotel.pojo;

import java.util.Date;

/**
 * 
 * ���ǽ����˵�ʵ����
 *
 */
public class Bill {
	// �˵����
	private String billNo;
	// ���ѽ��
	private Double expendPrice;
	// ����ʱ��
	private Date expendTime;
	// ������
	private String tallyPeople;

	// �ۿ�
	private int rebate;

	// ���ͱ��
	private int guestNo;

	// ���˱�ע
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

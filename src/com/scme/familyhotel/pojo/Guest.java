package com.scme.familyhotel.pojo;
/**
 * ������
 * 
 * @author ����
 *
 */
public class Guest {
	//���
	private int guestNo;
	//����
	private String guestName;
	//�Ա�
	private String gender;
	//�绰
	private String phone;
	//��ַ
	private String address;
	//֤������
	private String credeType;
	//֤������
	private String credeNum;
	//��������
	private String guestType;
	//ʵ��Ѻ��
	private double realCash;
	//����Ѻ��
	private double collecPrice;
	//��ע
	private String guestRemark;
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Guest(String guestName, String gender, String phone, String address, String credeType, String credeNum,
			String guestType, double realPrice, double collecPrice, String guestRemark) {
		super();
		this.guestName = guestName;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.credeType = credeType;
		this.credeNum = credeNum;
		this.guestType = guestType;
		this.realCash = realPrice;
		this.collecPrice = collecPrice;
		this.guestRemark = guestRemark;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCredeType() {
		return credeType;
	}
	public void setCredeType(String credeType) {
		this.credeType = credeType;
	}
	public String getCredeNum() {
		return credeNum;
	}
	public void setCredeNum(String credeNum) {
		this.credeNum = credeNum;
	}
	public String getGuestType() {
		return guestType;
	}
	public void setGuestType(String guestType) {
		this.guestType = guestType;
	}
	public double getRealCash() {
		return realCash;
	}
	public void setRealCash(double realPrice) {
		this.realCash = realPrice;
	}
	public double getCollecPrice() {
		return collecPrice;
	}
	public void setCollecPrice(double collecPrice) {
		this.collecPrice = collecPrice;
	}
	public String getGuestRemark() {
		return guestRemark;
	}
	public void setGuestRemark(String guestRemark) {
		this.guestRemark = guestRemark;
	}
	
	
	public int getGuestNo() {
		return guestNo;
	}
	public void setGuestNo(int guestNo) {
		this.guestNo = guestNo;
	}
	
}

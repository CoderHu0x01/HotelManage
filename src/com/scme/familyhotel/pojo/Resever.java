package com.scme.familyhotel.pojo;

import java.util.Date;

/**
 * Ԥס��Ϣ
 * 
 * @author ����
 *
 */
public class Resever {

	// ������
	private String roomNo;
	// Ԥסʱ��
	private Date reseverTime;
	// Ԥ��ʱ��
	private Date estime;
	// ��������
	private Date restaintime;
	// Ԥס����
	private int liveDay;
	// Ԥ����ע
	private String resRemark;

	public Resever() {
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public Date getReseverTime() {
		return reseverTime;
	}

	public void setReseverTime(Date reseverTime) {
		this.reseverTime = reseverTime;
	}

	public Date getEstime() {
		return estime;
	}

	public void setEstime(Date estime) {
		this.estime = estime;
	}

	public Date getRestaintime() {
		return restaintime;
	}

	public void setRestaintime(Date restaintime) {
		this.restaintime = restaintime;
	}

	public int getLiveDay() {
		return liveDay;
	}

	public void setLiveDay(int liveDay) {
		this.liveDay = liveDay;
	}

	public String getResRemark() {
		return resRemark;
	}

	public void setResRemark(String resRemark) {
		this.resRemark = resRemark;
	}

}

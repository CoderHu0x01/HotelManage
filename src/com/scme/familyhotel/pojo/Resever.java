package com.scme.familyhotel.pojo;

import java.util.Date;

/**
 * 预住信息
 * 
 * @author 胡贵东
 *
 */
public class Resever {

	// 房间编号
	private String roomNo;
	// 预住时间
	private Date reseverTime;
	// 预抵时间
	private Date estime;
	// 保留天数
	private Date restaintime;
	// 预住天数
	private int liveDay;
	// 预定备注
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

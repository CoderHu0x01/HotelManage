package com.scme.familyhotel.pojo;

/**
 * 房间类
 * @author 胡贵东
 *
 */
public class Room {
	//主键
	//String roomID;
	//房间编号
	private String roomNo;
	//房间单价
	private String roomPrice;
	//宾客编号
	private int guestNo;
	//宾客人数
	private int guestNum;
	//房间类型
	private String roomType;
	//房间状态
	private String roomState;
	//房间备注信息
	private String roomRemark;
	//所属楼层
	private String floor;
	//房间电话
	private String roomPhone;
	
	public String getRoomPhone() {
		return roomPhone;
	}
	public void setRoomPhone(String roomPhone) {
		this.roomPhone = roomPhone;
	}
	public Room() {
	}
	public Room(String roomNo, String roomPrice, int guestNo, int guestNum, String roomType, String roomState,
			String roomRemark, String floor) {
		super();
		this.roomNo = roomNo;
		this.roomPrice = roomPrice;
		this.guestNo = guestNo;
		this.guestNum = guestNum;
		this.roomType = roomType;
		this.roomState = roomState;
		this.roomRemark = roomRemark;
		this.floor = floor;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}
	public int getGuestNo() {
		return guestNo;
	}
	public void setGuestNo(int guestNo) {
		this.guestNo = guestNo;
	}
	public int getGuestNum() {
		return guestNum;
	}
	public void setGuestNum(int guestNum) {
		this.guestNum = guestNum;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomState() {
		return roomState;
	}
	public void setRoomState(String roomState) {
		this.roomState = roomState;
	}
	public String getRoomRemark() {
		return roomRemark;
	}
	public void setRoomRemark(String roomRemark) {
		this.roomRemark = roomRemark;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	
	
}

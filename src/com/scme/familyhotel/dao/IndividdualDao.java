package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.Bill;
import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Room;

public interface IndividdualDao {
	// 散客开单中插入用户数据
	public abstract void createGueInfo(Guest guest);

	// 散客开单中插入房间数据
	public abstract void createRoomInfo(int guestNum, String roomNo);

	public abstract void createRoomInfo2(int guestNo, String roomNo);

	public abstract void createRoomInfo3(String roomNo);

	public abstract void createRes(String roomNo, int liveDay);

	public abstract int findGuestNo(String credeNum);

	// 显示可供房间
	public abstract ArrayList<Room> queryHaveRoom();

	// 更新房间状态
	public abstract void updateRoomState(String roomState, String roomNo);

	// 插入入住单号
	void insertBillInfo(Bill bill);

	// 按房间编号查询房间单价
	double queryRoomPrice(String roomNo);

}

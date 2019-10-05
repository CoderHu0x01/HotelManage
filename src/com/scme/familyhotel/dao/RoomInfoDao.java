package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.Bill;
import com.scme.familyhotel.pojo.Room;

/**
 * 这是宾客接口
 * 
 * @author 胡贵东
 *
 */
public interface RoomInfoDao {
	//增加
	//public abstract void createRoomInfo(int guestRoom,String roomNo);

	//查找
	public abstract ArrayList<Room> find(String roomNo);
	
	
	//通过房间编号查询出结账信息
	Bill queryBillInfo(String roomNo);
}

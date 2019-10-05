package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.Room;

/**
 * ==============团体开单借口============
 * 
 * @author 胡贵东
 *
 */
public interface GroupDao {
	//查找房间信息和单价
	ArrayList<Room> queryRoomNoPrice(String roomType);
	
}

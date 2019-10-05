package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.Room;

public interface GroupBillingDao {
	//按房间类型查询房间
	public abstract ArrayList<Room> queryTypeRoom(String roomType);
	
	
}

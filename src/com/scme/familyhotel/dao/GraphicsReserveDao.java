package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Resever;

public interface GraphicsReserveDao {
	// 查询房间编号
	ArrayList<String> queryRoomNo(String roomType);

	// 插入预定信息
	void insertResGuest(Guest guest);

	void inserResever(Resever res, String roomNo);

	void createRoomInfo(String roomNo);
}

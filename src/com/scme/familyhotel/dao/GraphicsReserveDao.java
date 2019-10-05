package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Resever;

public interface GraphicsReserveDao {
	// ��ѯ������
	ArrayList<String> queryRoomNo(String roomType);

	// ����Ԥ����Ϣ
	void insertResGuest(Guest guest);

	void inserResever(Resever res, String roomNo);

	void createRoomInfo(String roomNo);
}

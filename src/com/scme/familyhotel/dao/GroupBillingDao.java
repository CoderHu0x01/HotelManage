package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.Room;

public interface GroupBillingDao {
	//���������Ͳ�ѯ����
	public abstract ArrayList<Room> queryTypeRoom(String roomType);
	
	
}

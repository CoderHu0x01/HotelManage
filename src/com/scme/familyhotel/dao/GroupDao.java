package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.Room;

/**
 * ==============���忪�����============
 * 
 * @author ����
 *
 */
public interface GroupDao {
	//���ҷ�����Ϣ�͵���
	ArrayList<Room> queryRoomNoPrice(String roomType);
	
}

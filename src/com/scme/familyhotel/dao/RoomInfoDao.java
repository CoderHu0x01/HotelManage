package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.Bill;
import com.scme.familyhotel.pojo.Room;

/**
 * ���Ǳ��ͽӿ�
 * 
 * @author ����
 *
 */
public interface RoomInfoDao {
	//����
	//public abstract void createRoomInfo(int guestRoom,String roomNo);

	//����
	public abstract ArrayList<Room> find(String roomNo);
	
	
	//ͨ�������Ų�ѯ��������Ϣ
	Bill queryBillInfo(String roomNo);
}

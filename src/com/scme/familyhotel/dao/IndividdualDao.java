package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.Bill;
import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Room;

public interface IndividdualDao {
	// ɢ�Ϳ����в����û�����
	public abstract void createGueInfo(Guest guest);

	// ɢ�Ϳ����в��뷿������
	public abstract void createRoomInfo(int guestNum, String roomNo);

	public abstract void createRoomInfo2(int guestNo, String roomNo);

	public abstract void createRoomInfo3(String roomNo);

	public abstract void createRes(String roomNo, int liveDay);

	public abstract int findGuestNo(String credeNum);

	// ��ʾ�ɹ�����
	public abstract ArrayList<Room> queryHaveRoom();

	// ���·���״̬
	public abstract void updateRoomState(String roomState, String roomNo);

	// ������ס����
	void insertBillInfo(Bill bill);

	// �������Ų�ѯ���䵥��
	double queryRoomPrice(String roomNo);

}

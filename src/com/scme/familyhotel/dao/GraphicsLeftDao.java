package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.Room;

public interface GraphicsLeftDao {
	/*
	 * ��ѯ���Ϸ���Ϣ
	 */
	// ����Ų�ѯԤ�赥�ۣ�����绰������¥��
	public abstract Room queryLeftRoomInfo(String roomNo);

	// ��ѯ�����������ѽ�Ѻ�𣬷��䵥�ۣ�¥��,����ʱ��
	public ArrayList<Object> findGuestNR(String roomNo);

	/*
	 * //��ѯ���·���Ϣ
	 */
	// ���ҷ�������
	public abstract int queryLeftRoomAll();

	// ���ҷ���ռ��״̬
	public abstract int roomCount(String roomState);

}

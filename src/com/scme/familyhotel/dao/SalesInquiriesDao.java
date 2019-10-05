package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.Bill;

public interface SalesInquiriesDao {
	// ��ѯ��������Ϣ
	ArrayList<ArrayList<Object>> queryBillInfo();

	// ȫ��������Ϣ��ѯ
	ArrayList<ArrayList<Object>> queryAllGuestInfo();

	// ������������֤����źͷ���Ų�ѯ
	ArrayList<ArrayList<Object>> queryNCRO(String data);

	// �ڵ�������Ѳ�ѯ
	ArrayList<ArrayList<Object>> consumeInfo();

	//�ڵ�������� ����ֹʱ���ѯ
	ArrayList<ArrayList<Object>> queryConsumetTime(String data1, String data2);
	
	//�ڵ�������� ������Ų�ѯ
		ArrayList<ArrayList<Object>> queryConsumetRoomNo(String data);

	// ������Ѳ�ѯ
	ArrayList<ArrayList<Object>> leaveInfo();

	// ������������ź��˵��Ų�ѯ
	ArrayList<ArrayList<Object>> queryNRZInfo(String data);

	// ����ֹʱ���ѯ
	ArrayList<ArrayList<Object>> queryTimenfo(String data1, String data2);

}

package com.scme.familyhotel.dao;

public interface CheckOutDao {
	//���ͷ���Ų�����ס���ţ����˵��ţ��ͱ�������
	String queryBillNameInfo(String roomNo);
	
	//�������˱�ע
	void insertRemark(String billNo,String billRemark);
	
}

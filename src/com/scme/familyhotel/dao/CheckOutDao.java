package com.scme.familyhotel.dao;

public interface CheckOutDao {
	//按客房编号查找入住单号（结账单号）和宾客姓名
	String queryBillNameInfo(String roomNo);
	
	//新增结账备注
	void insertRemark(String billNo,String billRemark);
	
}

package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.Bill;

public interface SalesInquiriesDao {
	// 查询出结账信息
	ArrayList<ArrayList<Object>> queryBillInfo();

	// 全部宾客信息查询
	ArrayList<ArrayList<Object>> queryAllGuestInfo();

	// 按宾客姓名，证件编号和房间号查询
	ArrayList<ArrayList<Object>> queryNCRO(String data);

	// 在店宾客消费查询
	ArrayList<ArrayList<Object>> consumeInfo();

	//在店宾客消费 按截止时间查询
	ArrayList<ArrayList<Object>> queryConsumetTime(String data1, String data2);
	
	//在店宾客消费 按房间号查询
		ArrayList<ArrayList<Object>> queryConsumetRoomNo(String data);

	// 离店消费查询
	ArrayList<ArrayList<Object>> leaveInfo();

	// 按姓名，房间号和账单号查询
	ArrayList<ArrayList<Object>> queryNRZInfo(String data);

	// 按截止时间查询
	ArrayList<ArrayList<Object>> queryTimenfo(String data1, String data2);

}

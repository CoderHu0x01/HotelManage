package com.scme.familyhotel.dao;

import java.util.ArrayList;

import com.scme.familyhotel.pojo.Room;

public interface GraphicsLeftDao {
	/*
	 * 查询左部上方信息
	 */
	// 按编号查询预设单价，房间电话，所属楼层
	public abstract Room queryLeftRoomInfo(String roomNo);

	// 查询宾客姓名和已交押金，房间单价，楼层,进店时间
	public ArrayList<Object> findGuestNR(String roomNo);

	/*
	 * //查询左部下方信息
	 */
	// 查找房间总数
	public abstract int queryLeftRoomAll();

	// 查找房间占用状态
	public abstract int roomCount(String roomState);

}

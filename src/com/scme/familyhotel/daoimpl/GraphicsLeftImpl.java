package com.scme.familyhotel.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.scme.familyhotel.dao.GraphicsLeftDao;
import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Room;

public class GraphicsLeftImpl implements GraphicsLeftDao {
	// 左边上部房间信息
	// 按编号查询预设单价，房间电话，所属楼层
	@Override
	public Room queryLeftRoomInfo(String roomNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select roomPrice,roomPhone,floor from tb_roomInfo where roomNo=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, roomNo);

			rs = ps.executeQuery();
			while (rs.next()) {
				room=new Room();
				room.setRoomPrice(rs.getString("roomPrice"));
				room.setRoomPhone(rs.getString("roomPhone"));
				room.setFloor(rs.getString("floor"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return room;
	}

	// 查询宾客姓名和已交押金，房间单价，楼层,进店时间
	@Override
	public ArrayList<Object> findGuestNR(String roomNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Guest guest = null;
		Room roomInfo = null;
		// 存储查询出的信息
		ArrayList<Object> listG = new ArrayList<Object>();

		try {
			conn = JdbcUtils.getConnection();

			String sql = "select g.guestName,g.realCash,r.guestNo,r.roomPhone ,r.floor,r.roomPrice from tb_guest as g join tb_roomInfo as r on g.guestNo=r.guestNo where r.roomNo=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, roomNo);

			rs = ps.executeQuery();
			System.out.println("宾客姓名\t已交押金\t房间单价\t所在区域");
			while (rs.next()) {
				guest = new Guest();
				roomInfo = new Room();

				guest.setGuestName(rs.getString("guestName"));
				guest.setRealCash(rs.getDouble("realCash"));
				guest.setGuestNo(rs.getInt("guestNo"));
				roomInfo.setRoomPhone(rs.getString("roomPhone"));
				roomInfo.setFloor(rs.getString("floor"));
				roomInfo.setRoomPrice(rs.getString("roomPrice"));

				listG.add(guest);
				listG.add(roomInfo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return listG;
	}

	/*
	 * 左部下方房间总状态
	 * 
	 */
	// 查找房间总数
	@Override
	public int queryLeftRoomAll() {
		Connection conn = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		int countRoom = 0;

		try {
			conn = JdbcUtils.getConnection();

			String sql2 = "select count(roomId) from tb_roominfo";
			ps2 = conn.prepareStatement(sql2);
			rs = ps2.executeQuery();

			System.out.println("房间总数");
			while (rs.next()) {
				countRoom = rs.getInt("count(roomId)");
				System.out.println(countRoom);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps2, conn);
		}

		return countRoom;

	}

	// 统计房间状态数量
	@Override
	public int roomCount(String roomState) {
		Connection conn = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		int count = 1;

		try {
			conn = JdbcUtils.getConnection();

			String sql2 = "select count(roomState) from tb_roominfo where roomState=?";
			ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, roomState);

			rs = ps2.executeQuery();
			System.out.println("当前占用总数");
			while (rs.next()) {
				count = rs.getInt("count(roomState)");
				System.out.println(count);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps2, conn);
		}

		return count;
	}

}

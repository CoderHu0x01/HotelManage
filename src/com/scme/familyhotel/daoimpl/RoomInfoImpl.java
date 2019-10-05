package com.scme.familyhotel.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.scme.familyhotel.dao.RoomInfoDao;
import com.scme.familyhotel.pojo.Bill;
import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Room;

/**
 * ������Ϣʵ����
 * 
 * @author ����
 *
 */
public class RoomInfoImpl implements RoomInfoDao {

	//
	@Override
	public ArrayList<Room> find(String roomType) {
		// ���ϴ洢��ѯ���ķ�����Ϣ
		ArrayList<Room> roomNoList = new ArrayList<Room>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room = null;

		try {
			// ��������
			conn = JdbcUtils.getConnection();

			String sql = "select roomNo,roomState,roomPrice from tb_roomInfo WHERE roomType=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, roomType);

			rs = ps.executeQuery();

			System.out.println("������\t\t����״̬");
			while (rs.next()) {
				room = new Room();
				String sNo = rs.getString("roomNo");
				String sState = rs.getString("roomState");
				String sPrice = rs.getString("roomPrice");
				room.setRoomNo(sNo);
				room.setRoomState(sState);
				room.setRoomType(roomType);
				room.setRoomPrice(sPrice);
				roomNoList.add(room);
				System.out.println(rs.getString("roomNo") + "\t" + rs.getString("roomState"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}

		return roomNoList;

	}

	// ͨ�������Ų�ѯ��������Ϣ
	@Override
	public Bill queryBillInfo(String roomNo) {
		// ���ϴ洢��ѯ���ķ�����Ϣ
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Bill bill = null;

		try {
			// ��������
			conn = JdbcUtils.getConnection();

			String sql = "select b.billNo,b.expendPrice,b.expendTime,b.tallyPeople,b.rebate from tb_bill as b JOIN tb_guest as g ON b.guestNo=g.guestNo JOIN tb_roominfo as r ON g.guestNo=r.guestNo WHERE r.roomNo=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, roomNo);

			rs = ps.executeQuery();

			while (rs.next()) {
				bill = new Bill();
				bill.setBillNo(rs.getString("billNo"));
				bill.setExpendPrice(rs.getDouble("expendPrice"));
				bill.setExpendTime(rs.getTimestamp("expendTime"));
				bill.setTallyPeople(rs.getString("tallyPeople"));
				bill.setRebate(rs.getInt("rebate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}

		return bill;
	}

}

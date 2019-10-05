package com.scme.familyhotel.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.scme.familyhotel.dao.IndividdualDao;
import com.scme.familyhotel.pojo.Bill;
import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Room;

public class IndividdualDaoImpl implements IndividdualDao {

	// 添加房间信息
	@Override
	public void createGueInfo(Guest guest) {
		Connection conn = null;
		PreparedStatement ps = null;

		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();

			String sql = "insert into tb_guest(credeType,crederNum,gender,guestType,guestName,address,guestRemark,realCash) values(?,?,?,?,?,?,?,?) ";

			ps = conn.prepareStatement(sql);
			ps.setString(1, guest.getCredeType());
			ps.setString(2, guest.getCredeNum());
			ps.setString(3, guest.getGender());
			ps.setString(4, guest.getGuestType());
			ps.setString(5, guest.getGuestName());
			ps.setString(6, guest.getAddress());
			ps.setString(7, guest.getGuestRemark());
			ps.setDouble(8, guest.getRealCash());

			int i = ps.executeUpdate();
			System.out.println(i);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			JdbcUtils.free(rs, ps, conn);
		}

	}

	// 增加房间信息
	@Override
	public void createRoomInfo(int guestNum, String roomNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();

			String sql = "update tb_roomInfo set guesNum=?,roomState='当前占用' where roomNo=?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, guestNum);
			ps.setString(2, roomNo);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}

	}

	@Override
	public void createRoomInfo2(int guestNo, String roomNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "update tb_roomInfo set guestNo=? where roomNo=?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, guestNo);
			ps.setString(2, roomNo);

			int i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}

	}

	// 增加预住信息
	@Override
	public void createRes(String roomNo, int liveDay) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();

			String sql = "insert into tb_reseverInfo(roomNo,liveDay) values(?,?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, roomNo);
			ps.setInt(2, liveDay);

			int i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}

	}

	// 通过身份证查找宾客编号
	@Override
	public int findGuestNo(String credeNum) {
		Connection conn = null;

		PreparedStatement ps2 = null;
		ResultSet rs = null;
		int no = 0;

		try {
			conn = JdbcUtils.getConnection();

			String sql2 = "select guestNo from tb_guest where crederNum=?";
			ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, credeNum);

			rs = ps2.executeQuery();
			System.out.println("宾客编号");
			while (rs.next()) {
				no = rs.getInt("guestNo");

				System.out.println(rs.getInt("guestNo"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps2, conn);
		}

		return no;
	}

	// 显示可供房间和实际单价
	@Override
	public ArrayList<Room> queryHaveRoom() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room hRoom = null;
		ArrayList<Room> haveList = new ArrayList<Room>();

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select roomNo,roomPrice from tb_roomInfo where roomState='当前可用'";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				hRoom = new Room();
				hRoom.setRoomNo(rs.getString("roomNo"));
				hRoom.setRoomPrice(rs.getString("roomPrice"));
				haveList.add(hRoom);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}

		return haveList;
	}

	// 更新房间状态
	@Override
	public void updateRoomState(String roomState, String roomNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "update tb_roomInfo set roomState=? where roomNo=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, roomState);
			ps.setString(2, roomNo);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}

	}

	// 向结账账单表中插入信息
	@Override
	public void insertBillInfo(Bill bill) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into tb_bill(billNo,expendPrice,guestNo,expendTime,rebate,tallyPeople) values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, bill.getBillNo());
			ps.setDouble(2, bill.getExpendPrice());
			ps.setInt(3, bill.getGuestNo());
			ps.setTimestamp(4, (Timestamp) bill.getExpendTime());
			ps.setInt(5, bill.getRebate());
			ps.setString(6, bill.getTallyPeople());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}

	}

	// 按房间编号查询房间单价
	@Override
	public double queryRoomPrice(String roomNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		double roomPrice = 0;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select roomPrice from tb_roomInfo where roomNo=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, roomNo);

			rs = ps.executeQuery();
			while (rs.next()) {
				roomPrice = rs.getDouble("roomPrice");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return roomPrice;
	}

	// 增加房间信息
	@Override
	public void createRoomInfo3(String roomNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();

			String sql = "update tb_roomInfo set roomState='当前占用' where roomNo=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, roomNo);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}

	}
	// public static void main(String[] args){
	//
	// Bill bill=new Bill();
	// bill.setBillNo("111111111");
	// bill.setExpendPrice(200.0);
	// bill.setGuestNo(40);
	// bill.setExpendTime(new Date(10000));
	//
	// new IndividdualDaoImpl().insertBillInfo(bill);
	// }
}

package com.scme.familyhotel.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.scme.familyhotel.dao.SalesInquiriesDao;

public class SalesInquiriesDaoImpl implements SalesInquiriesDao {
	// 查询出结账信息
	@Override
	public ArrayList<ArrayList<Object>> queryBillInfo() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ArrayList<Object>> listTemp = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> listBillInfo = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select b.billNo,r.roomNo ,g.guestName ,b.expendPrice,g.realCash,b.expendTime,b.billRemark from tb_bill as b JOIN tb_guest as g ON b.guestNo=g.guestNo JOIN tb_roominfo as r ON g.guestNo=r.guestNo";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				listBillInfo = new ArrayList<Object>();

				String billNo = rs.getString("billNo");
				String roomNo = rs.getString("roomNo");
				String guestName = rs.getString("guestName");
				Double expendPrice = rs.getDouble("expendPrice");
				Double realCash = rs.getDouble("realCash");
				Date expendTime = rs.getDate("expendTime");
				String billRemark = rs.getString("billRemark");

				listBillInfo.add(billNo);
				listBillInfo.add(roomNo);
				listBillInfo.add(guestName);
				listBillInfo.add(expendPrice);
				listBillInfo.add(realCash);
				listBillInfo.add(expendTime);
				listBillInfo.add(billRemark);

				listTemp.add(listBillInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return listTemp;
	}

	// 全部宾客信息查询
	@Override
	public ArrayList<ArrayList<Object>> queryAllGuestInfo() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ArrayList<Object>> listAllInfo = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> guestAllInfo = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select r.roomNo ,g.guestName, g.gender ,g.crederNum,g.credeType,r.guesNum,g.realCash,res.liveDay,b.expendTime from tb_bill as b JOIN tb_guest as g ON b.guestNo=g.guestNo JOIN tb_roominfo as r ON g.guestNo=r.guestNo JOIN tb_reseverinfo  as res ON res.roomNo=r.roomNo";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				guestAllInfo = new ArrayList<Object>();

				String roomNo = rs.getString("roomNo");
				String guestName = rs.getString("guestName");
				String gender = rs.getString("gender");
				String crederNum = rs.getString("crederNum");
				String credeType = rs.getString("credeType");
				int guesNum = rs.getInt("guesNum");
				Double realCash = rs.getDouble("realCash");
				int liveDay = rs.getInt("liveDay");
				Date expendTime = rs.getDate("expendTime");

				guestAllInfo.add("*");
				guestAllInfo.add(roomNo);
				guestAllInfo.add(guestName);
				guestAllInfo.add(gender);
				guestAllInfo.add(crederNum);
				guestAllInfo.add(credeType);
				guestAllInfo.add(guesNum);
				guestAllInfo.add(realCash);
				guestAllInfo.add(liveDay);
				guestAllInfo.add("正在消费");
				guestAllInfo.add(expendTime);
				guestAllInfo.add("*");
				guestAllInfo.add("*");

				listAllInfo.add(guestAllInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return listAllInfo;

	}

	// 在店宾客消费查询
	@Override
	public ArrayList<ArrayList<Object>> consumeInfo() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ArrayList<Object>> listConsumeInfo = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> consumeInfo = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select b.billNo,r.roomNo,r.roomType,r.roomPrice,b.rebate,b.expendTime from tb_bill as b JOIN tb_roominfo as r ON b.guestNo=r.guestNo";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				consumeInfo = new ArrayList<Object>();

				String billNo = rs.getString("billNo");
				String roomNo = rs.getString("roomNo");
				Double roomPrice = rs.getDouble("roomPrice");
				String roomType = rs.getString("roomType");
				int rebate = rs.getInt("rebate");
				Date expendTime = rs.getDate("expendTime");

				consumeInfo.add(roomNo);
				consumeInfo.add(roomType);
				consumeInfo.add(roomPrice);
				consumeInfo.add(rebate);
				consumeInfo.add(roomPrice * 0.9);
				consumeInfo.add(roomPrice * 0.1);
				consumeInfo.add(expendTime);

				listConsumeInfo.add(consumeInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return listConsumeInfo;

	}

	// 离店宾客消费查询
	@Override
	public ArrayList<ArrayList<Object>> leaveInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ArrayList<Object>> queryNRZInfo(String data) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ArrayList<Object>> listNRZInfo = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> NRZInfo = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select b.billNo,r.roomNo ,g.guestName ,b.expendPrice,g.realCash,b.expendTime,b.billRemark from tb_bill as b JOIN tb_guest as g ON b.guestNo=g.guestNo JOIN tb_roominfo as r ON g.guestNo=r.guestNo WHERE g.guestName=? OR r.roomNo=? OR b.billNo=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, data);
			ps.setString(2, data);
			ps.setString(3, data);

			rs = ps.executeQuery();
			while (rs.next()) {
				NRZInfo = new ArrayList<Object>();

				String billNo = rs.getString("billNo");
				String roomNo = rs.getString("roomNo");
				String guestName = rs.getString("guestName");
				Double expendPrice = rs.getDouble("expendPrice");
				Double realCash = rs.getDouble("realCash");
				Date expendTime = rs.getDate("expendTime");
				String billRemark = rs.getString("billRemark");

				NRZInfo.add(billNo);
				NRZInfo.add(roomNo);
				NRZInfo.add(guestName);
				NRZInfo.add(expendPrice);
				NRZInfo.add(realCash);
				NRZInfo.add(expendTime);
				NRZInfo.add(billRemark);

				listNRZInfo.add(NRZInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return listNRZInfo;

	}

	@Override
	public ArrayList<ArrayList<Object>> queryTimenfo(String data1, String data2) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ArrayList<Object>> listNRZInfo = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> NRZInfo = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select b.billNo,r.roomNo ,g.guestName ,b.expendPrice,g.realCash,b.expendTime,b.billRemark from tb_bill as b JOIN tb_guest as g ON b.guestNo=g.guestNo JOIN tb_roominfo as r ON g.guestNo=r.guestNo WHERE b.expendTime BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, data1);
			ps.setString(2, data2);

			rs = ps.executeQuery();
			while (rs.next()) {
				NRZInfo = new ArrayList<Object>();

				String billNo = rs.getString("billNo");
				String roomNo = rs.getString("roomNo");
				String guestName = rs.getString("guestName");
				Double expendPrice = rs.getDouble("expendPrice");
				Double realCash = rs.getDouble("realCash");
				Date expendTime = rs.getDate("expendTime");
				String billRemark = rs.getString("billRemark");

				NRZInfo.add(billNo);
				NRZInfo.add(roomNo);
				NRZInfo.add(guestName);
				NRZInfo.add(expendPrice);
				NRZInfo.add(realCash);
				NRZInfo.add(expendTime);
				NRZInfo.add(billRemark);

				listNRZInfo.add(NRZInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return listNRZInfo;
	}

	@Override
	public ArrayList<ArrayList<Object>> queryNCRO(String data) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ArrayList<Object>> listAllInfo = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> guestAllInfo = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select r.roomNo ,g.guestName, g.gender ,g.crederNum,g.credeType,r.guesNum,g.realCash,res.liveDay,b.expendTime from tb_bill as b JOIN tb_guest as g ON b.guestNo=g.guestNo JOIN tb_roominfo as r ON g.guestNo=r.guestNo JOIN tb_reseverinfo as res ON res.roomNo=r.roomNo WHERE g.guestName=? OR g.crederNum=? OR r.roomNo=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, data);
			ps.setString(2, data);
			ps.setString(3, data);
			rs = ps.executeQuery();

			while (rs.next()) {
				guestAllInfo = new ArrayList<Object>();

				String roomNo = rs.getString("roomNo");
				String guestName = rs.getString("guestName");
				String gender = rs.getString("gender");
				String crederNum = rs.getString("crederNum");
				String credeType = rs.getString("credeType");
				int guesNum = rs.getInt("guesNum");
				Double realCash = rs.getDouble("realCash");
				int liveDay = rs.getInt("liveDay");
				Date expendTime = rs.getDate("expendTime");

				guestAllInfo.add("*");
				guestAllInfo.add(roomNo);
				guestAllInfo.add(guestName);
				guestAllInfo.add(gender);
				guestAllInfo.add(crederNum);
				guestAllInfo.add(credeType);
				guestAllInfo.add(guesNum);
				guestAllInfo.add(realCash);
				guestAllInfo.add(liveDay);
				guestAllInfo.add("正在消费");
				guestAllInfo.add(expendTime);
				guestAllInfo.add("*");
				guestAllInfo.add("*");

				listAllInfo.add(guestAllInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return listAllInfo;
	}

	@Override
	public ArrayList<ArrayList<Object>> queryConsumetTime(String data1, String data2) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ArrayList<Object>> listConsumeInfo = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> consumeInfo = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select b.billNo,r.roomNo,r.roomType,r.roomPrice,b.rebate,b.expendTime from tb_bill as b JOIN tb_roominfo as r ON b.guestNo=r.guestNo WHERE b.expendTime BETWEEN ? AND ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, data1);
			ps.setString(2, data2);

			rs = ps.executeQuery();

			while (rs.next()) {
				consumeInfo = new ArrayList<Object>();

				String billNo = rs.getString("billNo");
				String roomNo = rs.getString("roomNo");
				Double roomPrice = rs.getDouble("roomPrice");
				String roomType = rs.getString("roomType");
				int rebate = rs.getInt("rebate");
				Date expendTime = rs.getDate("expendTime");

				consumeInfo.add(roomNo);
				consumeInfo.add(roomType);
				consumeInfo.add(roomPrice);
				consumeInfo.add(rebate);
				consumeInfo.add(roomPrice * 0.9);
				consumeInfo.add(roomPrice * 0.1);
				consumeInfo.add(expendTime);

				listConsumeInfo.add(consumeInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return listConsumeInfo;
	}

	@Override
	public ArrayList<ArrayList<Object>> queryConsumetRoomNo(String data) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ArrayList<Object>> listConsumeInfo = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> consumeInfo = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select b.billNo,r.roomNo,r.roomType,r.roomPrice,b.rebate,b.expendTime from tb_bill as b JOIN tb_roominfo as r ON b.guestNo=r.guestNo WHERE r.roomNo=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, data);

			rs = ps.executeQuery();

			while (rs.next()) {
				consumeInfo = new ArrayList<Object>();

				String billNo = rs.getString("billNo");
				String roomNo = rs.getString("roomNo");
				Double roomPrice = rs.getDouble("roomPrice");
				String roomType = rs.getString("roomType");
				int rebate = rs.getInt("rebate");
				Date expendTime = rs.getDate("expendTime");

				consumeInfo.add(roomNo);
				consumeInfo.add(roomType);
				consumeInfo.add(roomPrice);
				consumeInfo.add(rebate);
				consumeInfo.add(roomPrice * 0.9);
				consumeInfo.add(roomPrice * 0.1);
				consumeInfo.add(expendTime);

				listConsumeInfo.add(consumeInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return listConsumeInfo;
	}

}

package com.scme.familyhotel.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.scme.familyhotel.dao.GraphicsReserveDao;
import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Resever;

public class GraphicsReserveDaoImpl implements GraphicsReserveDao {

	@Override
	public ArrayList<String> queryRoomNo(String roomType) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<String> listRoomNo = new ArrayList<String>();

		try {
			conn = JdbcUtils.getConnection();

			String sql = "select roomNo from tb_roomInfo where roomType=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, roomType);

			rs = ps.executeQuery();
			while (rs.next()) {
				listRoomNo.add(rs.getString("roomNo"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listRoomNo;
	}

	//// 插入预定信息
	@Override
	public void insertResGuest(Guest guest) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();

			String sql = "insert into tb_guest(guestName,phone) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, guest.getGuestName());
			ps.setString(2, guest.getPhone());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void inserResever(Resever res, String roomNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();

			String sql = "update tb_reseverInfo set estime=?,restaintime=?,resRemark=?,resevertime=? where roomNo=?";
			ps = conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(res.getEstime().getTime()));
			ps.setDate(2, new java.sql.Date(res.getRestaintime().getTime()));
			ps.setString(3, res.getResRemark());
			ps.setDate(4, new java.sql.Date(res.getReseverTime().getTime()));
			ps.setString(5, roomNo);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void createRoomInfo(String roomNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();

			String sql = "update tb_roomInfo set roomState='当前预定' where roomNo=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, roomNo);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}

	}

}

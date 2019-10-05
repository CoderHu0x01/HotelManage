package com.scme.familyhotel.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.scme.familyhotel.dao.CheckOutDao;

public class CheckOutDaoImpl implements CheckOutDao {
	// 按客房编号查找入住单号（结账单号）和宾客姓名
	@Override
	public String queryBillNameInfo(String roomNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// ArrayList<String> listBillName = new ArrayList<String>();
		String guestName = null;

		try {
			conn = JdbcUtils.getConnection();

			String sql = "select g.guestName from tb_guest as g join tb_roomInfo as r on g.guestNo=r.guestNo where r.roomNo=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, roomNo);

			rs = ps.executeQuery();
			while (rs.next()) {

				guestName = rs.getString("guestName");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return guestName;
	}

	// 新增结账备注
	@Override
	public void insertRemark(String billRemark, String billNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();

			String sql = "UPDATE tb_bill SET billRemark=? WHERE billNo=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, billRemark);
			ps.setString(2, billNo);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

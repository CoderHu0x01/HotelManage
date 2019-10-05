package com.scme.familyhotel.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.scme.familyhotel.dao.UserDao;
import com.scme.familyhotel.pojo.User;


public class UserDaoImpl implements UserDao {

	// µ«¬º
	@Override
	public User login(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User checkUser = null;

		try {
			conn = JdbcUtils.getConnection();

			String sql = "select userName,password from tb_user where userName=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());

			rs = ps.executeQuery();
			while (rs.next()) {
				checkUser = new User();
				checkUser.setUserName(rs.getString("userName"));
				checkUser.setPassword(rs.getString("password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return checkUser;

	}

	// ≤È’“”√ªß
	@Override
	public ArrayList<User> findUser() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		ArrayList<User> usreList = new ArrayList<User>();

		try {
			conn = JdbcUtils.getConnection();

			String sql = "select userName from tb_user";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserName(rs.getString("userName"));
				usreList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
		return usreList;
	}


}

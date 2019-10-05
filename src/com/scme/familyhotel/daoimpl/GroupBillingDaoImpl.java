package com.scme.familyhotel.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Room;

public class GroupBillingDaoImpl implements com.scme.familyhotel.dao.GroupBillingDao {

	@Override
	public ArrayList<Room> queryTypeRoom(String roomType) {
		Connection connection = null;
		PreparedStatement Statement = null;
		ResultSet resultSet = null;
		Room room = null;
		ArrayList<Room> roomInfoList = new ArrayList<Room>();
		try {
			connection = JdbcUtils.getConnection();
			Statement = connection.prepareStatement("select roomNo,roomPrice from tb_roominfo where roomType=?");
			Statement.setString(1, roomType);

			resultSet = Statement.executeQuery();

			while (resultSet.next()) {
				room = new Room();
				String roomNo = resultSet.getString("roomNo");
				String roomPrice = resultSet.getString("roomPrice");
				room.setRoomNo(roomNo);
				room.setRoomPrice(roomPrice);
				roomInfoList.add(room);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.free(resultSet, Statement, connection);
		}

		return roomInfoList;
	}

	public void selectAllguest(Guest guest) {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();
			String Sql = "INSERT into tb_guest(credeType,guestType,gender,crederNum,guestName,address,guestRemark,realCash) VALUES(?,?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(Sql);
			statement.setString(1, guest.getCredeType());
			statement.setString(2, guest.getGuestType());
			statement.setString(3, guest.getGender());
			statement.setString(4, guest.getCredeNum());
			statement.setString(5, guest.getGuestName());
			statement.setString(6, guest.getAddress());
			statement.setString(7, guest.getGuestRemark());
			statement.setDouble(8, guest.getRealCash());

			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.free(null, statement, connection);
		}

	}

	public void insertRoom(Room room, String groupRoomNo) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();
			String Sql = "update tb_roominfo(guesNum,guestNo) set guesNum=?,guestNo=?";
			statement = connection.prepareStatement(Sql);
			statement.setInt(1, room.getGuestNum());
			statement.setInt(2, room.getGuestNo());

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.free(null, statement, connection);
		}
	}

}

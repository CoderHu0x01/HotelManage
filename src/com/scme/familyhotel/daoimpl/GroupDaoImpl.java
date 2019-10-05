package com.scme.familyhotel.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.scme.familyhotel.dao.GroupDao;
import com.scme.familyhotel.pojo.Guest;
import com.scme.familyhotel.pojo.Room;

public class GroupDaoImpl implements GroupDao {
	
	//查找房间信息和单价
	@Override
	public ArrayList<Room> queryRoomNoPrice(String roomType) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Room room=null;
		ArrayList<Room> roomNoPriceList = new ArrayList<Room>();
		
		try {
			conn=JdbcUtils.getConnection();
			String sql="select roomNo,roomPrice from tb_roomInfo where roomType=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, roomType);
			
			rs=ps.executeQuery();
			while(rs.next()){
				room=new Room();
				room.setRoomNo(rs.getString("roomNo"));
				room.setRoomPrice(rs.getString("roomPrice"));
				roomNoPriceList.add(room);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.free(rs, ps, conn);
		}

		return roomNoPriceList;
	}
	
}

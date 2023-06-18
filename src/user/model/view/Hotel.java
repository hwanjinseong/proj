package user.model.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Hotel {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Connection conn;
		PreparedStatement psmt;
		ResultSet rs;
		String sql = "";

		String id = scn.nextLine();
		String pw = scn.nextLine();
		conn = Dao.getConnect();

		sql = "select * from hotel_user where user_id = ? and user_pw = ?";

		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs=psmt.executeQuery();
			
			if(rs.next()) {
				roomVO room = new roomVO();
				
				room.setGuest(rs.getString("user_id"));
				room.setRoomtype(rs.getString("user_pw"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

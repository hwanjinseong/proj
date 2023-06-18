package sos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMain {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","proj","proj");
			System.out.println("연결성공");	
		}catch (ClassNotFoundException e) {
			System.out.println("로딩 실패");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
	}
}

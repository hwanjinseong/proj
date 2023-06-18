package user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import user.common.JDBCTemplate;
import user.model.vo.UserVO;

public class UserDAOImpl implements UserDAO {

	public UserVO searchOneUser(String userId, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		UserVO userVO = null;

		try {
			String sql = "SELECT * FROM MEMBERTABLE WHERE USERID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				userVO = new UserVO();

				userVO.setUserId(rset.getString("userid"));
				userVO.setUserName(rset.getString("username"));
				userVO.setUserEmail(rset.getString("useremail"));
				userVO.setUserDate(rset.getDate("userdate"));
			} else {
				System.out.println("해당 값이 존재하지 않습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return userVO;
	}

	public ArrayList<UserVO> searchUserAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		UserVO userVO = null;
		try {

			String sql = "SELECT * FROM MEMBERTABLE ORDER BY 1";
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				userVO = new UserVO();
				userVO.setUserId(rset.getString("userid"));
				userVO.setUserName(rset.getString("username"));
				userVO.setUserEmail(rset.getString("useremail"));
				userVO.setUserDate(rset.getDate("userdate"));
				list.add(userVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public UserVO createUser(String userName, String userid, String userPassword, String userEmail, Connection conn) {
		PreparedStatement pstmt = null;
		int rset = 0;

		UserVO userVO = null;
		try {
			String sql = "INSERT INTO MEMBERTABLE VALUES(memberindex.NEXTVAL,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userid);
			pstmt.setString(3, userPassword);
			pstmt.setString(4, userEmail);

			rset = pstmt.executeUpdate();
			System.out.println("rset : " + rset);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return userVO;
	}

	public UserVO searchUserData(String searchUserId, String searchUserName, Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		UserVO userVO = null;

		try {
			String sql = "SELECT * FROM MEMBERTABLE WHERE USERID = ? AND USERNAME = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchUserId);
			pstmt.setString(2, searchUserName);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				userVO = new UserVO();
				userVO.setUserId(rset.getString("userid"));
				userVO.setUserName(rset.getString("username"));
				System.out.println("해당 값이 존재합니다.");
			} else {
				System.out.println("해당 값이 존재하지 않습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return userVO;
	}

//update membertable
	// set userpassword='gildong12345', useremail='gildongpark@test.com'
	// where userid='gildong1';
	public UserVO modifyUser(String modifyPassword, String modifyEmail, String searchUserId, String searchUserName,
			Connection conn) {
		PreparedStatement pstmt = null;
		int rset = 0;

		UserVO userVO = null;

		try {
			String sql = "UPDATE MEMBERTABLE SET USERPASSWORD = ?, USEREMAIL = ? WHERE USERID =? AND USERNAME =?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, modifyPassword);
			pstmt.setString(2, modifyEmail);
			pstmt.setString(3, searchUserId);
			pstmt.setString(4, searchUserName);

			rset = pstmt.executeUpdate();
			if (rset > 0) {
				System.out.println("정상적으로 값이 변경되었습니다.");
				conn.commit();
			} else {
				System.out.println("정상적으로 값이 변경되지 않았습니다.");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return userVO;
	}

	public UserVO deleteUser(String deleteUserId, String deleteUserPassword, Connection conn) {

		PreparedStatement pstmt = null;
		int rset = 0;

		UserVO userVO = null;

		try {
			String sql = "DELETE FROM MEMBERTABLE WHERE USERID = ? AND USERPASSWORD =?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, deleteUserId);
			pstmt.setString(2, deleteUserPassword);

			rset = pstmt.executeUpdate();
			if (rset > 0) {
				System.out.println("정상적으로 삭제되었습니다.");
				conn.commit();
			} else {
				System.out.println("값이 삭제되지 않았습니다.");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return userVO;
	}
}

package user.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import user.common.JDBCTemplate;
import user.model.dao.UserDAOImpl;
import user.model.vo.UserVO;

public class UserServiceImpl implements UserService {
	UserVO userVO = new UserVO();
	UserDAOImpl userdao = new UserDAOImpl();

	@Override
	public UserVO searchOneUser(String searchID) {
		Connection conn = JDBCTemplate.getConnection();
		userVO = userdao.searchOneUser(searchID, conn);
		JDBCTemplate.close(conn);
		return userVO;
	}

	public ArrayList<UserVO> searchUserAll() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<UserVO> userVO = userdao.searchUserAll(conn);
		JDBCTemplate.close(conn);
		return userVO;
	}

	public UserVO createUser(String userName, String userid, String userPassword, String userEmail) {
		Connection conn = JDBCTemplate.getConnection();
		userVO = userdao.createUser(userName, userid, userPassword, userEmail, conn);
		JDBCTemplate.close(conn);
		return userVO;
	}

	public UserVO searchUserData(String searchUserId, String searchUserName) {
		Connection conn = JDBCTemplate.getConnection();
		userVO = userdao.searchUserData(searchUserId, searchUserName, conn);
		return userVO;
	}

	public UserVO modifyUser(String modifyPassword, String modifyEmail, String searchUserId, String searchUserName) {
		Connection conn = JDBCTemplate.getConnection();
		userVO = userdao.modifyUser(searchUserId, searchUserName, modifyPassword, modifyEmail, conn);
		return userVO;
	}

	public UserVO deleteUser(String deleteUserId, String deleteUserPassword) {
		Connection conn = JDBCTemplate.getConnection();
		userVO = userdao.deleteUser(deleteUserId, deleteUserPassword, conn);
		return userVO;
	}
}

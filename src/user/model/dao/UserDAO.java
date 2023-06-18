package user.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import user.model.vo.UserVO;

public interface UserDAO {
	public UserVO searchOneUser(String userId, Connection conn);

	public ArrayList<UserVO> searchUserAll(Connection conn);
	
	public UserVO searchUserData(String searchUserId, String searchUserName, Connection conn);
	
	public UserVO createUser(String userName, String userid, String userPassword, String userEmail, Connection conn);
	
	public UserVO modifyUser(String modifyPassword, String modifyEmail, String searchUserId, String searchUserName, Connection conn);
	
	public UserVO deleteUser(String deleteUserId, String deleteUserPassword, Connection conn);
}

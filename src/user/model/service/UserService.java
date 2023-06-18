package user.model.service;

import java.util.ArrayList;

import user.model.vo.UserVO;

public interface UserService {
	UserVO searchOneUser(String searchID);

	ArrayList<UserVO> searchUserAll();
	
	public UserVO createUser(String userName, String userid, String userPassword, String userEmail);
	
	public UserVO searchUserData(String searchUserId, String searchUserName);
	
	public UserVO modifyUser(String modifyPassword, String modifyEmail, String searchUserId, String searchUserName);
	
	public UserVO deleteUser(String deleteUserId, String deleteUserPassword);
}

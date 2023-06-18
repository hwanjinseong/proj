package user.controller;

import java.util.ArrayList;

import user.model.service.UserServiceImpl;
import user.model.vo.UserVO;

public class UserController {
	private UserServiceImpl userService = new UserServiceImpl();

	/**
	 * 회원 한명 조회
	 */
	public UserVO searchOneUser(String searchID) {
		UserVO user = userService.searchOneUser(searchID);

		return user;
	}

	/**
	 * 회원 전체 조회
	 */
	public ArrayList<UserVO> searchUserAll() {
		ArrayList<UserVO> userAll = userService.searchUserAll();
		return userAll;
	}

	/**
	 * 회원 추가
	 */
	public UserVO createUser(String userName, String userid, String userPassword, String userEmail) {
		UserVO user = userService.createUser(userName, userid, userPassword, userEmail);
		return user;
	}

	/**
	 * 회원 데이터 조회
	 */
	public UserVO searchUserData(String searchUserId, String searchUserName) {
		UserVO search = userService.searchUserData(searchUserId, searchUserName);
		return search;
	}

	/**
	 * 회원 수정
	 */
	public UserVO modifyUser(String searchUserId, String searchUserName, String modifyPassword, String modifyEmail) {
		UserVO user = userService.modifyUser(searchUserId, searchUserName, modifyPassword, modifyEmail);
		return user;
	}

	/**
	 * 회원 삭제
	 */
	public UserVO deleteUserData(String searchUserId, String searchUserPassword) {
		UserVO user = userService.deleteUser(searchUserId, searchUserPassword);
		return user;
	}

}

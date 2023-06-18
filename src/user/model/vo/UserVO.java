package user.model.vo;

import java.sql.Date;

//User Value Object 
//데이터 저장용
public class UserVO {
	// 이름, 아이디, 패스워드

	/**
	 * 사용자 이름
	 */
	private String userName;

	/**
	 * 사용자 아이디
	 */
	private String userId;

	/**
	 * 사용자 비번
	 */
	private String userPasswd;

	/**
	 * 사용자 이메일
	 */
	private String userEmail;

	/**
	 * 사용자 가입일자
	 */
	private Date userDate;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserDate() {
		return userDate;
	}

	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}

	// toString 출력
	@Override
	public String toString() {
		return "UserVO [userName=" + userName + ", userId=" + userId + ", userPasswd=" + userPasswd + ", userEmail="
				+ userEmail + ", userDate=" + userDate + "]";
	}

}

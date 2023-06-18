package user.model.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import user.controller.UserController;
import user.model.vo.UserVO;

public class UserView {
	private Scanner sc = new Scanner(System.in);
	private UserController userCon = new UserController();
	private HashMap<Integer,Room> roomMap;
	
	public void run() {
		while (true) {
			System.out.println("-------애견호텔 회원관리-------");
			System.out.println("1. 회원 조회");
			System.out.println("2. 전체 회원 조회");
			System.out.println("3. 회원 추가");
			System.out.println("4. 회원 정보 변경");
			System.out.println("5. 회원 삭제");
			System.out.println("6. 종료");
			System.out.println("----------------------");
			System.out.print("입력 > ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				searchUserOne();
				break;
			case 2:
				searchUserAll();
				break;
			case 3:
				createUser();
				break;
			case 4:
				modifyUser();
				break;
			case 5:
				deleteUser();
				break;
			case 6:
				System.out.println("프로그램 종료");
				System.exit(0);
				return;
			}
		}
	}

	private void searchUserOne() {
		System.out.print("조회할 회원 ID 입력 : ");
		String searchID = sc.next();

		// searchId 값을 입력 받아서 컨트롤러에 값을 던져준다.
		UserVO userVO = userCon.searchOneUser(searchID);
		
        // 값이 비어있지 않다면
        if (userVO != null) {
			System.out.println("---조회할 정보---");
			System.out.println("이름 : " + userVO.getUserName());
			System.out.println("ID : " + userVO.getUserId());
			System.out.println("이메일 : " + userVO.getUserEmail());
			System.out.println("날짜 : " + userVO.getUserDate());
		// 값이 비어있을 경우
		} else {
			System.out.println("정보 없음");
		}
	}

	private void searchUserAll() {
		System.out.println("-------- 전체 회원 출력 ---------");
		ArrayList<UserVO> uList = userCon.searchUserAll();

		// ArrayList 배열로 모든 회원을 출력한다.
		if (uList != null) {
			for (UserVO user : uList) {
				System.out.println("이름 : " + user.getUserName());
				System.out.println("ID : " + user.getUserId());
				System.out.println("이메일 : " + user.getUserEmail());
				System.out.println("날짜 : " + user.getUserDate());
				System.out.println("-------------------------");
			}
		} else {
			System.out.println("현재 등록된 회원 정보가 없습니다.");
		}
	}

	private void createUser() {
		System.out.println("-------- 회원 정보 추가 --------");
		UserVO userVO;
		System.out.print("이름 입력 : ");
		String userName = sc.next();
		sc.nextLine();
		System.out.print("아이디 입력 : ");
		String userid = sc.next();
		sc.nextLine();
		System.out.print("비밀번호 입력 : ");
		String userPassword = sc.next();
		sc.nextLine();
		System.out.print("이메일 입력 : ");
		String userEmail = sc.next();
        // 값들을 입력받아 컨트롤러의 createUser 메서드에 값을 던져준다.
		userVO = userCon.createUser(userName, userid, userPassword, userEmail);
	}

	// update membertable
	// set userpassword='gildong12345', useremail='gildongpark@test.com'
	// where userid='gildong1';
	private void modifyUser() {
		UserVO userVO;
		System.out.println("-------- 회원 정보 변경 --------");
		// 확인용
        // 실질적으로 변경하기 위한 데이터가 존재하는지 확인하기 위해 아이디와 이름을 입력받는다.
		System.out.print("기존 아이디 입력 : ");
		String searchUserId = sc.next();
		System.out.print("기존 사용자 이름 입력 : ");
		String searchUserName = sc.next();
		userVO = userCon.searchUserData(searchUserId, searchUserName);
		
        // 아이디와 사용자이름 둘다 일치할 경우
        if (userVO != null) {
			System.out.println("정보가 일치하는 것을 확인하였습니다.");
			System.out.print("변경될 비밀번호 입력 : ");
			String modifyPassword = sc.next();
			System.out.print("변경될 이메일 입력 : ");
			String modifyEmail = sc.next();

			userVO = userCon.modifyUser(searchUserId, searchUserName, modifyPassword, modifyEmail);
		// 불일치할 경우
        } else {
			System.out.println("해당 정보와 일치하는 데이터가 없습니다.");
		}
	}

	// 사용자 정보를 삭제
	private void deleteUser() {
		UserVO userVO;
		System.out.println("-------- 회원 정보 삭제 --------");
		System.out.print("삭제할 아이디 입력 : ");
		String deleteUserId = sc.next();
		System.out.print("비밀번호 입력 : ");
		String deleteUserPassword = sc.next();
        // 아이디와 비밀번호를 담아서 넘겨준다.
		userVO = userCon.deleteUserData(deleteUserId, deleteUserPassword);
	}
	
	
	
	

	public UserView(){
		roomMap = new HashMap<>();
		sc = new Scanner(System.in);
		for (int i = 200; i < 500; i+=100) {
			for (int j = 1; j < 10; j++) {
				switch(i/100){
				case 2: 
					roomMap.put(i+j, new Room(i+j, "소형견", "-"));
					break;
				case 3: 
					roomMap.put(i+j, new Room(i+j, "중형견", "-"));
					break;
				case 4: 
					roomMap.put(i+j, new Room(i+j, "대형견", "-"));
					break;
					
				}
			}
		}
	}


//  public static void main(String[] args) {
//	new UserView().roomStart();
//}

	
	//호텔 시작
	public void roomStart(){
		System.out.println();
		System.out.println("*********************************************");
		System.out.println(" 애견호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		System.out.println();
		
		while(true){
			int choice = Task();
			switch(choice){
			case 1 :		 
				checkIn(); break;
			case 2 :		
				checkOut(); break;
			case 3 :		
				roomCondition(); break;
			case 4 : 
				System.out.println("*********************************************");
				System.out.println(" 호텔문을 닫았습니다.");
				System.out.println("*********************************************");
				return;
			default : 
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 선택하세요.");
			
		}
	  }
	}

	private void checkIn(){
		System.out.println("----------------------------------------------");
		System.out.println(" 체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println("* 201~209 : 소형견룸");
		System.out.println("* 301~309 : 중형견룸");
		System.out.println("* 401~409 : 대형견룸");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호 입력 >>");
		int roomnum = sc.nextInt();
		
		//방번호가 없을때
		 if(!roomMap.containsKey(roomnum)){
			 System.out.println(roomnum + "호 객실은 존재하지 않습니다.");
			 return;
		 }
		
		 //방에 사람이 있을때
		if(!roomMap.get(roomnum).getGuest().equals("-")){
			 System.out.println(roomnum + "호 객실은 이미 손님이 있습니다.");
			 return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.println("이름 입력 >>");
		String guest = sc.next();
		roomMap.get(roomnum).setGuest(guest);
		System.out.println("체크인이 완료되었습니다.");
	}

	private void checkOut(){
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.println("방번호 입력 >>");
		int roomnum = sc.nextInt();
		//체크인한 사람이 없을때
		if(!roomMap.containsKey(roomnum)){
			System.out.println(roomnum + "호 객실.");
			return;
		}
		if(roomMap.get(roomnum).getGuest().equals("-")){
			 System.out.println(roomnum + "호 객실은 체크인한 사람이 없습니다.");
			 return;
		}
		System.out.println(roomnum + "호 객실의"+roomMap.get(roomnum).getGuest()+"님을 체크아웃을 완료하였습니다.");
		roomMap.get(roomnum).setGuest("-");
		
		
	}

	private void roomCondition(){
		System.out.println("----------------------------------------------");
		System.out.println(" 현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호	 방 종류	 투숙객 이름");
		System.out.println("----------------------------------------------");
		List<Room>list = new ArrayList<>();
		for(Integer key : roomMap.keySet()){
			//맵에 있는 키값을 가져와서 set으로 반환해서 키에 넣기
			Room value = roomMap.get(key);
			list.add(value);
		}
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getRoomnum()+"\t"+list.get(i).getRoomtype()+"\t"+list.get(i).getGuest());
		}
		System.out.println("----------------------------------------------");
	}

	//업무 메서드
	private int Task(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
	    System.out.print("1.체크인 ");
	    System.out.print("2.체크아웃 ");
	    System.out.print("3.객실상태 ");
	    System.out.println("4.업무종료 "); 
	    System.out.println("-----------------------------------------------------------");
		System.out.println("선택>>");
		int num = sc.nextInt();
		
		return num;
		
	}

	
}


package user.model.view;


public class roomVO {
	private int roomnum;
	private String guest;
	private String roomtype;

	roomVO(){
	}
	
	public roomVO(int roomnum, String guest, String roomtype) {
		super();
		this.roomnum = roomnum;
		this.guest = guest;
		this.roomtype = roomtype;
	}

	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

}

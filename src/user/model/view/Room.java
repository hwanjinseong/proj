package user.model.view;

class Room implements Comparable<Room> {
	private int roomnum;
	private String roomtype;
	private String guest;

	public Room(int roomnum, String roomtype, String guest) {
		super();
		this.roomnum = roomnum;
		this.roomtype = roomtype;
		this.guest = guest;
	}

	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	@Override
	public String toString() {
		return roomnum + "\t" + roomtype + "\t" + guest;
	}

	@Override
	public int compareTo(Room o) {
		return Integer.compare(this.getRoomnum(), o.getRoomnum());
	}

}

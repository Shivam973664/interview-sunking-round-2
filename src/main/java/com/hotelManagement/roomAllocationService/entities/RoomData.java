package com.hotelManagement.roomAllocationService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="room")
public class RoomData{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="room_number")
	private int roomNumber;

	
	@Column(name="room_type")
	private String roomType;

	
//	@OneToMany
//	@JoinColumn(name="user_id")
//	private UserData userData;	

	//@OneToMany(mappedBy=
	//private Set<OccupiedDateRoomsData> set= new HashSet<>();
	
	@Column(name="location")
	private String location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	

//	public UserData getUserData() {
//		return userData;
//	}
//
//	public void setUserData(UserData userData) {
//		this.userData = userData;
//	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	
}


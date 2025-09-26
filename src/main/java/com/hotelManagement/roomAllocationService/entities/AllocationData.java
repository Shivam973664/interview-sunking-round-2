package com.hotelManagement.roomAllocationService.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="allocation")
public class AllocationData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private UserData userData;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="room_id")
	private RoomData roomData;
	
	@Column(name="occupied_date")
	private LocalDate occupiedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

	public RoomData getRoomData() {
		return roomData;
	}

	public void setRoomData(RoomData roomData) {
		this.roomData = roomData;
	}

	public LocalDate getOccupiedDate() {
		return occupiedDate;
	}

	public void setOccupiedDate(LocalDate occupiedDate) {
		this.occupiedDate = occupiedDate;
	}
	
	
	
	
	
}

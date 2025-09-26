package com.hotelManagement.roomAllocationService.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user_data")
public class UserData{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="user_name")
	private String name;
	
	@Column(name="email")
	private String email;
	
//	@OneToMany(mappedBy ="userData")
//	private Set<RoomData> set= new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public Set<RoomData> getSet() {
//		return set;
//	}
//
//	public void setSet(Set<RoomData> set) {
//		this.set = set;
//	}
//	
	
	
}


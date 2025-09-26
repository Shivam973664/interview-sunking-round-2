package com.hotelManagement.roomAllocationService.dtos;

import java.time.LocalDate;

public class UserInputLocationDateDTO {

	private String userName;
	
	private String userEmail;
	
	private String location;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
//	public UserInputLocationDateDTO(UserInputLocationDateDTOBuilder builder){
//		this.userEmail = builder.userName;
//		this.userName = builder.userEmail;
//		this.startDate = builder.startDate;
//		this.endDate = builder.endDate;
//		this.location = builder.location;
//	}
	
	
//	public static class UserInputLocationDateDTOBuilder{
//		private String userName;
//		
//		private String userEmail;
//		
//		private String location;
//		
//		private LocalDate startDate;
//		
//		private LocalDate endDate;
//		
//		UserInputLocationDateDTOBuilder(String userName,String userEmail, String location){
//			this.userEmail = userEmail;
//			this.userName = userName;
//			this.location = location;
//		}
//		
//		public UserInputLocationDateDTO build() {
//			return new  UserInputLocationDateDTO(this);
//		}
//		
//		public UserInputLocationDateDTOBuilder setStartDate(LocalDate startDate) {
//			this.startDate= startDate;
//			return this;
//		}
//		
//		public UserInputLocationDateDTOBuilder setEndDate(LocalDate endDate) {
//			this.endDate= endDate;
//			return this;
//		}
//		
//	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	
}

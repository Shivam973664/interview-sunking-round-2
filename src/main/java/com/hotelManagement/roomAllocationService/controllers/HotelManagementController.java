package com.hotelManagement.roomAllocationService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotelManagement.roomAllocationService.dtos.OutPutUserDTO;
import com.hotelManagement.roomAllocationService.dtos.UserInputLocationDateDTO;
import com.hotelManagement.roomAllocationService.services.RoomManagementService;

@RestController
public class HotelManagementController {

	@Autowired
	private RoomManagementService roomService;

	
	
//	@GetMapping("/api/dates/{location}")
//	public ResponseEntity<List<OutPutUserDTO>> getRoomsByDates(@PathVariable("location") String location,@RequestBody UserInputLocationDateDTO input){
//		return ResponseEntity.status(HttpStatus.OK).body(roomService.getRoomsByDates(input));
//	}
	
	@GetMapping("/api/dates/{location}")
	public ResponseEntity<List<OutPutUserDTO>> getRoomsByDates(@PathVariable("location") String location,@RequestBody UserInputLocationDateDTO input){
		return ResponseEntity.status(HttpStatus.OK).body(roomService.getRoomsByDatesHavingConditions(input));
	}

	@PostMapping("/api/room/{roomNumber}")
	public ResponseEntity<String> allocateRoom(@PathVariable("roomNumber") int id,@RequestBody UserInputLocationDateDTO input){
		return ResponseEntity.status(HttpStatus.OK).body(roomService.allocateRoom(id,input));
	}

}

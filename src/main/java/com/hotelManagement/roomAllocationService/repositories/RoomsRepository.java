package com.hotelManagement.roomAllocationService.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotelManagement.roomAllocationService.entities.RoomData;

public interface RoomsRepository extends JpaRepository<RoomData,Long>{
	@Query("select data from RoomData data where data.location =:location ")
	public List<RoomData> getByLocation(@Param("location") String location);
	
	@Query("select data from RoomData data where data.roomNumber=:roomNumber")
	public Optional<RoomData> getByRoomNumber(@Param("roomNumber") int roomNumber);
}

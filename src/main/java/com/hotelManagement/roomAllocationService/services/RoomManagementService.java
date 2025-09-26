package com.hotelManagement.roomAllocationService.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelManagement.roomAllocationService.dtos.OutPutUserDTO;
import com.hotelManagement.roomAllocationService.dtos.UserInputLocationDateDTO;
import com.hotelManagement.roomAllocationService.entities.AllocationData;
import com.hotelManagement.roomAllocationService.entities.RoomData;
import com.hotelManagement.roomAllocationService.entities.UserData;
import com.hotelManagement.roomAllocationService.repositories.RoomsRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class RoomManagementService {
	private RoomsRepository roomRep;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	RoomManagementService(RoomsRepository roomrep) {
		this.roomRep = roomrep;

	}

	public List<OutPutUserDTO> getRoomsByDates(UserInputLocationDateDTO input) {
		List<RoomData> list = roomRep.getByLocation(input.getLocation());
		List<OutPutUserDTO> list2 = list.stream().map(a -> {
			OutPutUserDTO o1 = new OutPutUserDTO();
			o1.setRoomNumber(a.getRoomNumber());
			o1.setRoomType(a.getRoomType());
			return o1;
		}).collect(Collectors.toList());
		return list2;

	}

	@Transactional
	public String allocateRoom(int roomNumber, UserInputLocationDateDTO input) {
		Optional<RoomData> room = roomRep.getByRoomNumber(roomNumber);
		if (room.isPresent()) {
			Query qry = entityManager.createQuery("select data from UserData data where data.email=:userEmail",
					UserData.class);
			qry.setParameter("userEmail", input.getUserEmail());
			UserData userData = qry.getResultList().isEmpty() ? null : (UserData) qry.getResultList().get(0);
			if (userData == null) {
				userData = new UserData();
				userData.setEmail(input.getUserEmail());
				userData.setName(input.getUserName());
				entityManager.persist(userData);
			}
			for(LocalDate date =input.getStartDate() ; !date.isAfter(input.getEndDate()) ; date= date.plusDays(1)) {
				AllocationData data = new AllocationData();
				data.setOccupiedDate(date);
				data.setRoomData(room.get());
				data.setUserData(userData);
				entityManager.persist(data);
			}
			return "pushed all the data";
		}
		
		return "failed to push data";

	}

	 

	public List<OutPutUserDTO> getRoomsByDatesHavingConditions(UserInputLocationDateDTO dto){
		Query qry =entityManager.createNativeQuery("select rm.room_number as room_number,rm.room_type \r\n"
				+ "from room rm  where rm.location= ? and not exists\r\n"
				+ " (select 1 from allocation ocd \r\n"
				+ "where ocd.room_id = rm.id and ocd.occupied_date\r\n"
				+ " between ? and ?)");	
		qry.setParameter(1,dto.getLocation());
		qry.setParameter(2,dto.getStartDate());
		qry.setParameter(3,dto.getEndDate());
		
		List<Object[]> result = qry.getResultList();

		List<OutPutUserDTO> res = result.stream().map(a->
				{
					OutPutUserDTO o1= new OutPutUserDTO();
					o1.setRoomNumber((int)a[0]);
					o1.setRoomType((String) a[1]);
					
					return o1;
				}
				).collect(Collectors.toList());
		return res;
		
	}

}

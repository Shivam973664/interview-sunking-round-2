

This is the logic i have added in the Interview.


@RestController
public class HotelManagement{

	@Autowired
	private RoomManagementService roomService;

	
	
	@GetMapping("/api/dates/{location}")
	public ResponseEntity<List<Rooms>> getRoomsByDates(@PathVariable("location") String location,@RequestBody StartEndDateDTo dates){
		return ResroomService.setStatus(HttpStatus.OK).body(getRoomsByDates(dates,location));
	}

	@PostMapping("/api/room/{id}")
	public ResponseEntity<Boolean> allocateRoom(@PathVariable("id") Long id,@RequestBody userDetails){
		reurn ResponseEntity<>(roomService.allocateRoom(id,userDetails));
	}


}




@Entity
@Table(name="room")
public class RoomData{
	
	@Id
	@GeneratedValue(strategy= GeneratedType.IDENTITY)
	private Long id;
	
	@Column(name="room_number")
	private int roomNumber;

	
	@Column(name="room_type")
	private String roomType;

	@Column(name="available")
	private Boolean isAvailable;

	@OneToMany
	@JoinColumn(name="user_id")
	private UserData userData;	

	//@OneToMany(mappedBy=
	//private Set<OccupiedDateRoomsData> set= new HashSet<>();
	
	@Column(name="location")
	private String location;

}


@Entity
@Table(name="user_data")
public class UserData{
	@Id
	@GeneratedValue(strategy= GeneratedType.IDENTITY)
	private Long id;

	private String name;
	
	@ManyToOne(mappedBy="userData")
	private Set<Rooms> set= new HashSet<>();
}

	


@Entity
@Table(name="occupied_Date_room")
public class OccupiedDateRoomsData{
	
	@Id
	@GeneratedValue(strategy= GeneratedType.IDENTITY)
	private Long id;
	
	private Long roomId;

	@Column(name="occupied_date")
	private Date occupiedDat;
	


}


@Service
public class RoomManagementService{
	private RoomsRepository roomRep;
	
	@Autowired
	private EntityManager entityManager;

	@Autowired
	RoomManagementService(RoomsRepository roomrep){
		this.roomRep = roomrep;
		
	}


	public List<RoomDataDTO> getRoomsByDates(StartEndDateDTo dates){
		List<RoomData> list = roomrep.getBydates(dates.getStartDate(),dates.getEndDate());
		List<RoomDataDTO> list = list.stream().map(a-> new RoomDataDTO(a)).collect(Collectors.toList());
		return list;
		
	}

	public String allocateRoom(Long id,UserDetails userDetails){
		Optional<RoomData> room = roomRep.findById(id);
		if(room.isPresent()){
			roomRep.save(room);
			
		}
		
		
	}

	public 

	public List<RoomDataDTO> getRoomsByDates(CommonDTO dto){
		Query qry =entityManager.createQuery("select * from room rm  where rm.location=? and not exists (select 1 from occupied_Date_room ocd where ocd.room_id = rm.id and ocd.occupied_date between ? and ?
");	
		qry.setParameter(dto.getLocation());
		qry.setParameter(dto.getstartDate());
		qry.setParameter(dto.getEndDat());
		
		List result = qry.executeResult();

		
		
	}
	
}

Room 
room_id location isAvialable 


occupied_date

public class RoomDataDTO{
	///constructor
	//gettersetter

}


interface RoomsRepository extends JpaRepository<RoomData,Long>{
	@Query("select data from RoomData data where data.location =:location and (data.occupieDate>:startDate or data.isAvailable =:true    )")
	public List<RoomData> getBydates();
}



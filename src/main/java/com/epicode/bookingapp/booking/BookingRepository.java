package com.epicode.bookingapp.booking;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
	
	@Query("SELECT COUNT(*) FROM Booking b WHERE b.user.id =:id AND b.validity =:validity")
	public int findByUserAndValidity(Long id, LocalDate validity);
	
	@Query("SELECT COUNT(*) FROM Booking b WHERE b.workstation.id =:id AND b.validity =:validity")
	public int findByWorkstationAndValidity(Long id, LocalDate validity);

	
}

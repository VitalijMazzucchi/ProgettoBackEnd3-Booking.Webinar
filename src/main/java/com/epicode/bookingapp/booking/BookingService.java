package com.epicode.bookingapp.booking;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.bookingapp.workstation.Workstation;
import com.epicode.bookingapp.workstation.WorkstationRepository;
import com.epicode.bookingapp.workstation.WorkstationService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookingService {

	@Autowired
	private BookingRepository br;

	public void create(Booking b) {
		int booking = findByUserAndValidity(b.getUser().getId(), b.getValidity());

		if (booking == 0) {

			int bookingWorkstation = findWorkstationByIdAndDate(b.getWorkstation().getId(), b.getValidity());

			if (bookingWorkstation < b.getWorkstation().getPartecipants()) {
				br.save(b);
			} else {
				log.error("the workstation is full");
			}

		} else {
			log.error("you have already booked for today");
		}
	}

	public Booking read(Long id) {
		return br.findById(id).get();
	}

	public void update(Booking building) {
		br.save(building);
	}

	public void delete(Long id) {
		br.deleteById(id);
	}

	public int findByUserAndValidity(Long id, LocalDate validity) {
		return br.findByUserAndValidity(id, validity);
	}

	public int findWorkstationByIdAndDate(Long id, LocalDate date) {
		return br.findByWorkstationAndValidity(id, date);
	}
}

package com.epicode.bookingapp.workstation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.lang.Nullable;

import com.epicode.bookingapp.booking.Booking;
import com.epicode.bookingapp.building.Building;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Workstation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	@Enumerated(EnumType.STRING)
	private TypeWorkstation type;
	private Integer partecipants;
	@ManyToOne()
	private Building building;
	@OneToMany(mappedBy = "workstation")
	List<Booking> bookings = new ArrayList<>();

	public Workstation(String description, TypeWorkstation type, Integer partecipants) {
		super();
		this.description = description;
		this.type = type;
		this.partecipants = partecipants;

	}

}

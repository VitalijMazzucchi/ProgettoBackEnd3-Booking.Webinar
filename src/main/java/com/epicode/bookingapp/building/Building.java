package com.epicode.bookingapp.building;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.epicode.bookingapp.workstation.Workstation;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Building {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String city;
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "building_id")
	private List<Workstation> workstations = new ArrayList<>();

	public Building(String name, String address, String city) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
	}

	public void addWorkstation(Workstation w) {
		workstations.add(w);
	}

}

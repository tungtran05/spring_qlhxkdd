package com.demo.baitaplonweb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "license_plate")
	private String licensePlate;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "carLife")
	private int carLife;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "seats_num")
	private int seatsNum;
	
	@Column(name = "years_of_use")
	private int yearOfUse;
	
	@Column(name = "last_maintenance")
	@Temporal(TemporalType.DATE)
	private Date lastMaintenance;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
	@JsonIgnore
	private List<Tour> tours;
}

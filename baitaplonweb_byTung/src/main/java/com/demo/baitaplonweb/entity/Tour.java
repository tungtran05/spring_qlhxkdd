package com.demo.baitaplonweb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tour")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tour implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "passengers_num")
	private int passengersNum;
	
	@Column(name = "fare")
	private float fare;
	
	@Column(name = "started_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startedAt;
	
	@Column(name = "finished_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date finishedAt;

	@ManyToOne
	@JoinColumn(name = "driver_id", referencedColumnName ="id")
//	@JsonIgnore
	private Staff driver;
	
	@ManyToOne
	@JoinColumn(name = "assistant_id", referencedColumnName = "id")
//	@JsonIgnore
	private Staff assistant;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id", referencedColumnName = "id")
//	@JsonIgnore
	private Vehicle vehicle;
	
	@ManyToOne
	@JoinColumn(name = "route_id", referencedColumnName = "id")
//	@JsonIgnore
	private Route route;
}

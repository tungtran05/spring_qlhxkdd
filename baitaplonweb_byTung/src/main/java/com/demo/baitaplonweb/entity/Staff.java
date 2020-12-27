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
@Table(name="staff")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Staff implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "id_card")
	private String idCard;
	
	@Column(name = "license_num")
	private String licenseNum;
	
	@Column(name = "license_type")
	private String licenseType;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name = "seniority")
	private int seniority;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
	@JsonIgnore
	private List<Tour> toursAsDriver;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "assistant")
	@JsonIgnore
	private List<Tour> toursAsAssistant;
	
}

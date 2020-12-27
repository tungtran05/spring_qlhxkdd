package com.demo.baitaplonweb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="routecomplexity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RouteComplexity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "salary_of_driver")
	private float salaryOfDriver;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "routeComplexity")
	@JsonIgnore
	private List<Route> routes;
	
}

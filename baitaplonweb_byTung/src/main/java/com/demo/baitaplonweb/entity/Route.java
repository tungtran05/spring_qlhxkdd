package com.demo.baitaplonweb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "route")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Route implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "entry_point")
	private String entryPoint;
	
	@Column(name = "end_point")
	private String endPoint;
	
	@Column(name = "route_length")
	private float routeLength;
	
	
	@JoinColumn(name = "routecomplexity_id", referencedColumnName = "id")
	@ManyToOne
	private RouteComplexity routeComplexity;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "route")
	@JsonIgnore
	private List<Tour> tours;
	
}

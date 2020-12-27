package com.demo.baitaplonweb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ThongKeVehicle implements Serializable{
	private Integer id;
	private String licensePlate;
	private float totalMoney;
}

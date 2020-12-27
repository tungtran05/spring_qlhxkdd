package com.demo.baitaplonweb.service;

import java.util.List;

import com.demo.baitaplonweb.entity.Vehicle;

public interface VehicleService {
	public List<Vehicle> findAll();
	public Vehicle findById(int theId);
	public void save(Vehicle theVehicle);
	public void deleteById(int theId);
	public List<Object> auditVehicle(String startDate, String endDate);
}

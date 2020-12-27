package com.demo.baitaplonweb.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.demo.baitaplonweb.dao.VehicleRepository;
import com.demo.baitaplonweb.entity.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {

	private VehicleRepository vehicleRepository;
	
	@Autowired
	public VehicleServiceImpl(VehicleRepository theVehicleRepository) {
		vehicleRepository = theVehicleRepository;
	}
	
	@Override
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle findById(int theId) {
		Optional<Vehicle> result = vehicleRepository.findById(theId);
		
		Vehicle theVehicle = null;
		if(result.isPresent()) {
			theVehicle = result.get();
		} else {
			throw new RuntimeException("Did not find vehicle - " + theId);
		}
		return theVehicle;
	}

	@Override
	public void save(Vehicle theVehicle) {
		vehicleRepository.save(theVehicle);
	}

	@Override
	public void deleteById(int theId) {
		vehicleRepository.deleteById(theId);
	}
	
	@Override
	public List<Object> auditVehicle(String startDate, String endDate) {
		return vehicleRepository.auditVehicle(startDate, endDate);
	}

}

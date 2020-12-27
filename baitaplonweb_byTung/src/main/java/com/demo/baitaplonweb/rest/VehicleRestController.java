package com.demo.baitaplonweb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.baitaplonweb.entity.Vehicle;
import com.demo.baitaplonweb.service.VehicleService;

@RestController
@RequestMapping("/api")
public class VehicleRestController {
	private VehicleService vehicleService;
	
	@Autowired
	public VehicleRestController(VehicleService theVehicleService) {
		vehicleService = theVehicleService;
	}
	
	// getAll
	@RequestMapping("/vehicles")
	public List<Vehicle> findAll() {
		return vehicleService.findAll();
	}
	
	// get by id
	@RequestMapping("/vehicles/{vehicleId}")
	public Vehicle getVehicle(@PathVariable int vehicleId ) {
		Vehicle vehicle = vehicleService.findById(vehicleId);
		if(vehicle == null)
			throw new RuntimeException("Vehicle is not found - " + vehicleId);
		return vehicle;
	}
	
	// add
	@PostMapping("/vehicles")
	public Vehicle addVehicle(@RequestBody Vehicle theVehicle) {
		theVehicle.setId(0);
		vehicleService.save(theVehicle);
		return theVehicle;
	}
	
	// update
	@PutMapping("/vehicles")
	public Vehicle updateVehicle(@RequestBody Vehicle theVehicle) {
		vehicleService.save(theVehicle);
		return theVehicle;
	}
	
	// delete
	@DeleteMapping("/vehicles/{vehicleId}")
	public String deleteVehicle(@PathVariable int vehicleId) {
		Vehicle theVehicle = vehicleService.findById(vehicleId);
		if(theVehicle == null)
			throw new RuntimeException("Vehicle is not found - " + vehicleId);
		
		vehicleService.deleteById(vehicleId);
		
		return "Delete vehicle id - " + vehicleId;
	}
	
	@GetMapping("/auditVehicle")
	public List<Object> auditVehicle(@RequestParam String startDate,@RequestParam String endDate) {
		return vehicleService.auditVehicle(startDate, endDate);
	}
	
}

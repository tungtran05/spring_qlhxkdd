package com.demo.baitaplonweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.baitaplonweb.dao.RouteRepository;
import com.demo.baitaplonweb.dao.StaffRepository;
import com.demo.baitaplonweb.dao.TourRepository;
import com.demo.baitaplonweb.dao.VehicleRepository;
import com.demo.baitaplonweb.entity.Tour;

@Service
public class TourServiceImpl implements TourService{
	
	@Autowired
	private TourRepository tourRepository;
	@Autowired
	private StaffRepository staffRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private RouteRepository routeRepository;
	
	

	@Override
	public List<Tour> findAll() {
		return tourRepository.findAll();
	}

	@Override
	public Tour findById(int theId) {
		Optional<Tour> result = tourRepository.findById(theId);
		
		Tour theTour = null;
		if(result.isPresent()) {
			theTour = result.get();
		} else {
			throw new RuntimeException("Did not find tour - " + theId);
		}
		
		return theTour;
	}

	@Override
	public void save(Tour tour, int driverId, int assistantId, int vehicleId, int routeId) {
		tour.setDriver(staffRepository.findById(driverId).get());
		tour.setAssistant(staffRepository.findById(assistantId).get());
		tour.setVehicle(vehicleRepository.findById(vehicleId).get());
		tour.setRoute(routeRepository.findById(routeId).get());
		
		tourRepository.save(tour);
		
	}

	@Override
	public void deleteById(int theId) {
		tourRepository.deleteById(theId);
		
	}
	

}

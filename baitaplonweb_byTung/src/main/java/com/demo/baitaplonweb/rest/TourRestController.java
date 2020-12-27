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

import com.demo.baitaplonweb.entity.Tour;
import com.demo.baitaplonweb.service.TourService;

@RestController
@RequestMapping("/api")
public class TourRestController {
	
	public TourService tourService;
	
	@Autowired
	public TourRestController(TourService theTourService) {
		tourService = theTourService;
	}
	
	// get all
	@GetMapping("/tours")
	public List<Tour> findAll() {
		return tourService.findAll();
	}
	
	// get by id
	@GetMapping("/tours/{theId}")
	public Tour findById(@PathVariable int theId) {
		Tour tour = tourService.findById(theId);
		if(tour == null) {
			throw new RuntimeException("Did not found tour id - " + theId);
		}
		return tour;
	}
	
	// add
	@PostMapping("/tours")
	public Tour saveTour(@RequestBody Tour tour, @RequestParam int driverId, @RequestParam int assistantId,
			 @RequestParam int vehicleId, @RequestParam int routeId) {
		tour.setId(0);
		tourService.save(tour, driverId, assistantId, vehicleId, routeId);
		return tour;
	}
	
	// update
	@PutMapping("/tours")
	public Tour updateTour(@RequestBody Tour tour, @RequestParam int driverId, @RequestParam int assistantId,
			@RequestParam int vehicleId, @RequestParam int routeId) {
		tourService.save(tour, driverId, assistantId, vehicleId, routeId);
		return tour;
	}
	
	// delete
	@DeleteMapping("/tours/{theId}")
	public String deleteTour(@PathVariable int theId) {
		Tour tour = tourService.findById(theId);
		if(tour==null) {
			throw new RuntimeException("Did not found tour id - " + theId);
		} 
		
		tourService.deleteById(theId);
		return "Delete tour id - " + theId;
	}

}

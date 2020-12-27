package com.demo.baitaplonweb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.baitaplonweb.entity.RouteComplexity;
import com.demo.baitaplonweb.service.RouteComplexityService;

@RestController
@RequestMapping("/api")
public class RouteComplexityRestController {
	private RouteComplexityService routeComplexityService;
	
	@Autowired
	public RouteComplexityRestController(RouteComplexityService theRouteComplexityService) {
		routeComplexityService = theRouteComplexityService;
	}
	
	// get all
	@GetMapping("/routeComplexities")
	public List<RouteComplexity> findAll(){
		return routeComplexityService.findAll();
	}
	
	// get by id
	@GetMapping("/routeComplexities/{routeComplexityId}")
	public RouteComplexity getRouteComplexity(@PathVariable int routeComplexityId) {
		RouteComplexity theRouteComplexity = routeComplexityService.findById(routeComplexityId);
		if(theRouteComplexity == null) {
			throw new RuntimeException("RouteComplexity is not found - " + routeComplexityId);
		}
		return theRouteComplexity;
	}
	
	// add
	@PostMapping("/routeComplexities")
	public ResponseEntity<RouteComplexity> addRouteComplexity(@RequestBody RouteComplexity theRouteComplexity) {
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		theRouteComplexity.setId(0);
		routeComplexityService.save(theRouteComplexity);
		return ResponseEntity.ok(theRouteComplexity);
	}
	
	// update
	@PutMapping("/routeComplexities")
	public RouteComplexity updateRouteComplexity(@RequestBody RouteComplexity theRouteComplexity) {
		routeComplexityService.save(theRouteComplexity);
		return theRouteComplexity;
	}
	
	// delete
	@DeleteMapping("/routeComplexities/{routeComplexityId}")
	public String deleteRouteComplexity(@PathVariable int routeComplexityId) {
		RouteComplexity tempRouteComplexity = routeComplexityService.findById(routeComplexityId);
		
		if(tempRouteComplexity == null) {
			throw new RuntimeException("RouteComplexity is not found - " + routeComplexityId);
		}
		
		routeComplexityService.deleteById(routeComplexityId);
		
		return "Delete routeComplexity id - " + routeComplexityId;
	}
	
}

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

import com.demo.baitaplonweb.entity.Route;
import com.demo.baitaplonweb.service.RouteService;

@RestController
@RequestMapping("/api")
public class RouteRestController {
	private RouteService routeService;
	
	@Autowired
	public RouteRestController(RouteService theRouteService) {
		routeService = theRouteService;
	}
	
	// get all
	@GetMapping("/routes")
	public List<Route> findAll() {
		return routeService.findAll();
	}
	
	// get by id
	@GetMapping("/routes/{routeId}")
	public Route getRoute(@PathVariable int routeId) {
		Route route = routeService.findById(routeId);
		if(route == null) {
			throw new RuntimeException("Route is not found - " + routeId);
		}
		return route;
	}
	
	// add
	@PostMapping("/routes")
	public Route addRoute(@RequestBody Route theRoute, @RequestParam int theRouteComplexityId) {
		theRoute.setId(0);
		routeService.save(theRoute, theRouteComplexityId);
		return theRoute;
	}
	
	// update
	@PutMapping("/routes")
	public Route updateRoute(@RequestBody Route theRoute, @RequestParam int theRouteComplexityId) {
		routeService.save(theRoute, theRouteComplexityId);
		return theRoute;
	}
	
	// delete
	@DeleteMapping("/routes/{routeId}")
	public String deleteRoute(@PathVariable int routeId) {
		Route theRoute = routeService.findById(routeId);
		
		if(theRoute == null) {
			throw new RuntimeException("Route is not found - " + routeId);
		}
		
		routeService.deleteById(routeId);
		
		return "Delete route id - " + routeId;
	}
}

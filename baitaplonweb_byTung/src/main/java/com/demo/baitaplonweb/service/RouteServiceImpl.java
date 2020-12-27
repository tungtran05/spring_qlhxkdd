package com.demo.baitaplonweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.baitaplonweb.dao.RouteComplexityRepository;
import com.demo.baitaplonweb.dao.RouteRepository;
import com.demo.baitaplonweb.entity.Route;

@Service
public class RouteServiceImpl implements RouteService {
	
	@Autowired
	private RouteRepository routeRepository;
	@Autowired
	private RouteComplexityRepository routeComplexityRepository;
	

	@Override
	public List<Route> findAll() {
		return routeRepository.findAll();
	}

	@Override
	public Route findById(int theId) {
		Optional<Route> result = routeRepository.findById(theId);
		
		Route theRoute = null;
		if(result.isPresent()) {
			theRoute = result.get();
		} else {
			throw new RuntimeException("Did not find route - " + theId);
		}
		return theRoute;
	}

	@Override
	public void save(Route theRoute, int routeComplexityId) {
		theRoute.setRouteComplexity(routeComplexityRepository.findById(routeComplexityId).get());
		routeRepository.save(theRoute);
	}

	@Override
	public void deleteById(int theId) {
		routeRepository.deleteById(theId);
	}

}

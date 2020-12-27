package com.demo.baitaplonweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.baitaplonweb.dao.RouteComplexityRepository;
import com.demo.baitaplonweb.entity.RouteComplexity;

@Service
public class RouteComplexityServiceImpl implements RouteComplexityService {
	
	private RouteComplexityRepository routeComplexityRepository;
	
	@Autowired
	public RouteComplexityServiceImpl(RouteComplexityRepository theRouteComplexityRepository) {
		routeComplexityRepository = theRouteComplexityRepository;
	}

	@Override
	public List<RouteComplexity> findAll() {
		return routeComplexityRepository.findAll();
	}

	@Override
	public RouteComplexity findById(int theId) {
		Optional<RouteComplexity> result = routeComplexityRepository.findById(theId);
		
		RouteComplexity theRouteComplexity = null;
		if(result.isPresent()) {
			theRouteComplexity = result.get();
		} else {
			throw new RuntimeException("Did not find routeComplexity - " + theId);
		}
		return theRouteComplexity;
	}

	@Override
	public void save(RouteComplexity theRouteComplexity) {
		routeComplexityRepository.save(theRouteComplexity);
	}

	@Override
	public void deleteById(int theId) {
		routeComplexityRepository.deleteById(theId);
	}

}

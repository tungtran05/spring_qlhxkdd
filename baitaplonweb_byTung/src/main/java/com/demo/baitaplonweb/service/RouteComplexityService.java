package com.demo.baitaplonweb.service;

import java.util.List;

import com.demo.baitaplonweb.entity.RouteComplexity;

public interface RouteComplexityService {
	public List<RouteComplexity> findAll();
	public RouteComplexity findById(int theId);
	public void save (RouteComplexity theRouteComplexity);
	public void deleteById(int theId);
}

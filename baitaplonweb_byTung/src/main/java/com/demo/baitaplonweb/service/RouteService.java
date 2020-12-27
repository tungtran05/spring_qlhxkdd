package com.demo.baitaplonweb.service;

import java.util.List;

import com.demo.baitaplonweb.entity.Route;

public interface RouteService {
	public List<Route> findAll();
	public Route findById(int theId);
	public void save(Route theRoute, int routeComplexityId);
	public void deleteById(int theId);
}

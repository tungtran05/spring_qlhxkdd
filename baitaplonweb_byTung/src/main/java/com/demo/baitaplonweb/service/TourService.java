package com.demo.baitaplonweb.service;

import java.util.List;

import com.demo.baitaplonweb.entity.Tour;

public interface TourService {
	public List<Tour> findAll();
	public Tour findById(int theId);
	public void save(Tour tour, int driverId, int assistantId, int vehicleId, int routeId);
	public void deleteById(int theId);
}

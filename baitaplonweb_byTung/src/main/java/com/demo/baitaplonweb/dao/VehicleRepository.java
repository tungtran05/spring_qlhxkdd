package com.demo.baitaplonweb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.baitaplonweb.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	
	@Query(value="SELECT v.*, sum(t.passengers_num * t.fare) FROM Vehicle v JOIN Tour t ON v.id = t.vehicle_id "
			+ "WHERE date(t.finished_at) >= :startDate AND date(t.finished_at) <= :endDate "
			+ "GROUP BY v.id ORDER BY sum(t.passengers_num*t.fare) DESC", nativeQuery = true)
	public List<Object> auditVehicle(@Param("startDate") String startDate, @Param("endDate") String endDate);
}

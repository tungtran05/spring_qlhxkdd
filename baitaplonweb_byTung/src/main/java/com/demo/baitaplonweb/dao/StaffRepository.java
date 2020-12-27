package com.demo.baitaplonweb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.baitaplonweb.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{

	@Query(value="(SELECT s.id AS driverID, s.id_card, s.name, s.dob, sum(rc.salary_of_driver) "
			+ "FROM Tour t JOIN Route r ON t.route_id = r.id "
			+ "JOIN routeComplexity rc ON r.routecomplexity_id = rc.id "
			+ "JOIN Staff s ON s.id = t.driver_id "
			+ "WHERE date(t.finished_at) >= :startDate AND date(t.finished_at) <= :endDate "
			+ "GROUP BY t.driver_id "
			+ ") "
			+ "UNION"
			+ "(SELECT s.id AS driverID, s.id_card, s.name, s.dob, sum(rc.salary_of_driver)/2 "
			+ "FROM Tour t JOIN Route r ON t.route_id = r.id "
			+ "JOIN routeComplexity rc ON r.routecomplexity_id = rc.id "
			+ "JOIN Staff s ON s.id = t.assistant_id "
			+ "WHERE date(t.finished_at) >= :startDate AND date(t.finished_at) <= :endDate "
			+ "GROUP BY t.assistant_id "
			+ ")"
			+ "ORDER BY driverID", nativeQuery = true)
	public List<Object> auditSalaryOfDriver(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
//	@Query(value="(SELECT s.id, s.id_card, s.name, s.dob, sum(rc.salary_of_driver)/2 "
//			+ "FROM Tour t JOIN Route r ON t.route_id = r.id "
//			+ "JOIN routeComplexity rc ON r.routecomplexity_id = rc.id "
//			+ "JOIN Staff s ON s.id = t.assistant_id "
//			+ "WHERE date(t.finished_at) >= :startDate AND date(t.finished_at) <= :endDate "
//			+ "GROUP BY t.assistant_id "
//			+ "ORDER BY sum(rc.salary_of_driver) DESC)", nativeQuery = true)
//	public List<Object> auditSalaryOfAssistant(@Param("startDate") String startDate, @Param("endDate") String endDate);
}

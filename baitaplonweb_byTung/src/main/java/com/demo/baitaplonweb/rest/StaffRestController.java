package com.demo.baitaplonweb.rest;

import java.util.List;

import org.hibernate.annotations.Parameter;
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

import com.demo.baitaplonweb.entity.Staff;
import com.demo.baitaplonweb.service.StaffService;

@RestController
@RequestMapping("/api")
public class StaffRestController {
	public StaffService staffService;
	
	@Autowired
	public StaffRestController(StaffService theStaffService) {
		staffService = theStaffService;
	}
	
	// get all
	@GetMapping("/staffs")
	public List<Staff> findAll() {
		return staffService.findAll();
	}
	
	// get by id
	@GetMapping("/staffs/{theId}")
	public Staff findByid(@PathVariable int theId) {
		Staff staff = staffService.findById(theId);
		if(staff == null) 
			throw new RuntimeException("Staff is not found - " + theId);
		return staff;
	}
	
	// add
	@PostMapping("/staffs")
	public Staff addStaff(@RequestBody Staff theStaff) {
		theStaff.setId(0);
		staffService.save(theStaff);
		return theStaff;
	}
	
	// update
	@PutMapping("/staffs")
	public Staff updateStaff(@RequestBody Staff theStaff) {
		staffService.save(theStaff);
		return theStaff;
	}
	
	// delete
	@DeleteMapping("/staffs/{theId}")
	public String deleteStaff(@PathVariable int theId) {
		Staff staff = staffService.findById(theId);
		if(staff == null)
			throw new RuntimeException("Staff is not found - " + theId);
		staffService.deleteById(theId);
		
		return "Delete staff id - " + theId;
	}
	
	// audit salary of driver
	@GetMapping("/auditSalaryDriver")
	public List<Object> auditSalaryDriver(@RequestParam String startDate, @RequestParam String endDate) {
		return staffService.auditSalaryDriver(startDate, endDate);
	}
	
	// audit salary of assistant
//	@GetMapping("/auditSalaryAssistant")
//	public List<Object> auditSalaryAssistant(@RequestParam String startDate, @RequestParam String endDate){
//		return staffService.auditSalaryAssistant(startDate, endDate);
//	}
}

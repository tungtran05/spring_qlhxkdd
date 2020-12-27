package com.demo.baitaplonweb.service;

import java.util.List;

import com.demo.baitaplonweb.entity.Staff;

public interface StaffService {
	public List<Staff> findAll();
	public Staff findById(int theId);
	public void save(Staff theStaff);
	public void deleteById(int theId);
	public List<Object> auditSalaryDriver(String startDate, String endDate);
//	public List<Object> auditSalaryAssistant(String startDate, String endDate);
}

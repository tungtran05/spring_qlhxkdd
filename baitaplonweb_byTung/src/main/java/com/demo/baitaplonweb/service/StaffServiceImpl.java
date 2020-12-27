package com.demo.baitaplonweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.baitaplonweb.dao.StaffRepository;
import com.demo.baitaplonweb.entity.Staff;

@Service
public class StaffServiceImpl implements StaffService{
	
	private StaffRepository staffRepository;
	
	@Autowired
	public StaffServiceImpl(StaffRepository theStaffRepository) {
		staffRepository = theStaffRepository;
	}

	@Override
	public List<Staff> findAll() {
		
		return staffRepository.findAll();
	}

	@Override
	public Staff findById(int theId) {
		Optional<Staff> result = staffRepository.findById(theId);
		
		Staff staff = null;
		if(result.isPresent()) {
			staff = result.get();
		} else {
			throw new RuntimeException("Did not find staff id - " + theId);
		}
		return staff;
	}

	@Override
	public void save(Staff theStaff) {
		
		staffRepository.save(theStaff);
	}

	@Override
	public void deleteById(int theId) {
		
		staffRepository.deleteById(theId);
	}

	@Override
	public List<Object> auditSalaryDriver(String startDate, String endDate) {
		return staffRepository.auditSalaryOfDriver(startDate, endDate);
	}

//	@Override
//	public List<Object> auditSalaryAssistant(String startDate, String endDate) {
//		return staffRepository.auditSalaryOfAssistant(startDate, endDate);
//	}
	
	

}

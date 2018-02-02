package com.urs.systems.service;

import java.util.List;

import com.urs.systems.model.Status;


public interface StatusService {

	List<Status> getApplicableStatus(String applicableTo);
	
	boolean save(Status status);

	boolean updateStatus(Status status);

	boolean deleteStatus(Status status);
	
	
	

}

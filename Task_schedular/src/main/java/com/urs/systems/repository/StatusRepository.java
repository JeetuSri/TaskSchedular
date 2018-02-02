package com.urs.systems.repository;

import java.util.List;

import com.urs.systems.model.Status;

public interface StatusRepository {

	List<Status> getApplicableStatus(String applicableTo);

	boolean save(Status status);

	boolean updateStatus(Status status);

	boolean deleteStatus(Status status);
	
	
	

	


	

}

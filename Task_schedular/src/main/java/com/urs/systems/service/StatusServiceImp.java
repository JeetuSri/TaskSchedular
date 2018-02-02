package com.urs.systems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urs.systems.model.Status;
import com.urs.systems.repository.StatusRepository;

@Service
@Transactional
public class StatusServiceImp implements StatusService {
	
	@Autowired
	StatusRepository statusRepository;
	
	List<Status> Status;

	public List<Status> getStatus() {
		return Status;
	}

	public void setStatus(List<Status> status) {
		Status = status;
	}
	
	@Override
	public List<Status> getApplicableStatus(String applicableTo) {
		// TODO Auto-generated method stub
		return statusRepository.getApplicableStatus(applicableTo);
	}

	@Override
	public boolean save(Status status) {
		// TODO Auto-generated method stub
		return statusRepository.save(status);
		
	}

	@Override
	public boolean updateStatus(Status status) {
		// TODO Auto-generated method stub
		return statusRepository.updateStatus(status);
	}

	@Override
	public boolean deleteStatus(Status status) {
		// TODO Auto-generated method stub
		return statusRepository.deleteStatus(status);
	}

	

}

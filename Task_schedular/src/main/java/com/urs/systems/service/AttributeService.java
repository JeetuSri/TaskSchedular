package com.urs.systems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urs.systems.model.Attribute;
import com.urs.systems.repository.AttributeRepo;

@Service
public class AttributeService {

	@Autowired
	AttributeRepo attribute;
	
	public boolean createAttributes(Attribute a) {
		return attribute.createAttributes(a);
	}

	public boolean updateAttributes(Attribute a) {
		// TODO Auto-generated method stub
		return attribute.updateAttributes(a);
	}

	public boolean deleteAttributes(Attribute a) {
		// TODO Auto-generated method stub
		return attribute.deleteAttributes(a);
	}

	public List<Attribute> getAllAttribute() {
		// TODO Auto-generated method stub
		return attribute.getAllAttribute();
	}


}

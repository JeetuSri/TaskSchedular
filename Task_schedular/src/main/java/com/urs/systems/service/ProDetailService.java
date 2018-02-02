package com.urs.systems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urs.systems.model.ProductDetails;
import com.urs.systems.repository.ProDetailRepo;


@Service
@Transactional
public class ProDetailService {

	@Autowired
	ProDetailRepo proDetailRepo;
	
	public boolean createProduct_Details(ProductDetails prod) {
		// TODO Auto-generated method stub
		return proDetailRepo.createProduct_Details(prod);
	}

	public boolean deleteProduct_Details(ProductDetails prod) {
		// TODO Auto-generated method stub
		return proDetailRepo.deleteProduct_Details(prod);
	}

	public boolean updateProduct_Details(ProductDetails prod) {
		// TODO Auto-generated method stub
		return proDetailRepo.updateProduct_Details(prod);
	}

	public List<ProductDetails> getAllProduct_Details() {
		// TODO Auto-generated method stub
		return proDetailRepo.getAllProduct_Details();
	}

}

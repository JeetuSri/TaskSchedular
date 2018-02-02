package com.urs.systems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urs.systems.model.ProductType;
import com.urs.systems.repository.ProductTypeRepository;

@Service
@Transactional

public class ProductTypeService {
	
	@Autowired
	ProductTypeRepository ProductTypeRepositoryImp;
	

	public boolean updateProductType(ProductType pro) {
		// TODO Auto-generated method stub
		return ProductTypeRepositoryImp.updateProductType(pro);
	}

	public boolean save(ProductType productType) {
		// TODO Auto-generated method stub
		return ProductTypeRepositoryImp.save(productType);
	}

	public boolean deleteProducttype(ProductType prod) {
		// TODO Auto-generated method stub
		return ProductTypeRepositoryImp.deleteProducttype(prod);
	}

	public List<ProductType> getProduct_type() {
		// TODO Auto-generated method stub
		return ProductTypeRepositoryImp.getProduct_type();
	}	
}

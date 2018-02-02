package com.urs.systems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urs.systems.model.Category;
import com.urs.systems.repository.CategoryRepositoryImp;

@Service
@Transactional
public class CategoryServiceImp {

	@Autowired
	CategoryRepositoryImp CategoryRepository;
	
	 
	
	public boolean save(Category category) {
		return CategoryRepository.save(category);
	}
	
//	public Category findById(int id) {
//		// TODO Auto-generated method stub
//		return  CategoryRepository.findById(id);
//	}
//
//	public int deleteUserById(int id) {
//		// TODO Auto-generated method stub
//		return CategoryRepository.deleteUser(id);
//	}


	public boolean deleteCategories(Category cat) {
		// TODO Auto-generated method stub
		return  CategoryRepository.deleteCategories(cat);
	}


	public boolean updateCategories(Category cat) {
		// TODO Auto-generated method stub
		return  CategoryRepository.updateCategories(cat);
	}


	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return CategoryRepository.getAllCategories();
	}


	


	
}


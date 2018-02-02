package com.urs.systems.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.urs.systems.model.Category;
import com.urs.systems.model.ProductType;

@Repository
@Transactional
public class CategoryRepositoryImp {

	@Autowired
	private SessionFactory sessionFactory;
	
	 
	
	public boolean save(Category category) {
//		return (Category)sessionFactory.getCurrentSession().get(Category.class,sessionFactory.getCurrentSession().save(category));
//	}
		Session ss = sessionFactory.openSession();
		Transaction tx = ss.beginTransaction();
		 
		ss.save(category);
////		 Category cat =(Category) sessionFactory.getCurrentSession().get(Category.class, category.getProduct_category_id()); 
////		 cat.setProduct_category(category.getProduct_category());
//		Query query = sessionFactory.getCurrentSession().createQuery("from Category u where u.product_category_id=:id");
//	
//		query.setInteger("id",1);
////		List<ProductType> product=query.list();
//		List<Category> list = new ArrayList();
//		
//		System.out.println(list);
//		category.setProductTypes(null);
//		list.add(category);
		tx.commit();
		ss.close();
		return true;
	}
	
//	public Category findById(int id){
//		  Query query = sessionFactory.getCurrentSession().createQuery("from Category u where u.product_category_id=:product_category_id");
//		  query.setInteger("product_category_id",id);
//		  List<Category> list = (List<Category>)query.list();
//		  if(list.size()>0){
//		   return list.get(0);
//		  }
//		  return null;
//		 }
//	
//	public Category findById(int id) {
//		// TODO Auto-generated method stub
//		 
//		for(Category category : categorys){
//            if(category.getProduct_category_id() == id){
//            	return category;
//            }
//		}
//		 return null;
//    }
     
		
//	public int deleteUser(int id) {
//		 for (Iterator<Category> iterator = categorys.iterator(); iterator.hasNext(); ) {
//			 Category category = iterator.next();
//	            if (category.getProduct_category_id() == id) {
//	                iterator.remove();
//	            }
//		 }
//		 return 0;
//	    }

	
	
	 public boolean deleteCategories(Category c) {
	  
	  Session session = sessionFactory.openSession();
	  Category cat = (Category) session.createCriteria(Category.class).add(Restrictions.eq("product_category_id", c.getProduct_category_id())).uniqueResult();
	  
	  
	  Transaction tx = session.beginTransaction();
	  session.delete(cat);
	  tx.commit();
	  session.close();
	  
	  return true;
	 }

	
		 public boolean updateCategories(Category c) {
		  Session session = sessionFactory.openSession();
		  Transaction tx = session.beginTransaction();
		  Category cat =(Category) sessionFactory.getCurrentSession().get(Category.class, c.getProduct_category_id()); 
		  cat.setProduct_category(c.getProduct_category());
		  tx.commit();
		  session.close();
		  return true;
		  
		 }

		public List<Category> getAllCategories() {
			// TODO Auto-generated method stub
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from Category");
			List<Category> catlist = q.list();
			
			return catlist;
		}
}

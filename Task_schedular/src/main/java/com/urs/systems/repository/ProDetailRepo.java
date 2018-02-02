package com.urs.systems.repository;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.urs.systems.model.ProductDetails;

@Repository
@Transactional
public class ProDetailRepo {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean createProduct_Details(ProductDetails prod) {
		
		Session session = sessionFactory.openSession();
//		ProductDetails pt = new ProductDetails();
//
//		pt.setProduct_details_type_id(prod.getProduct_details_type_id());
//		pt.setProduct_details_attribute_id(prod.getProduct_details_attribute_id());
		session.save(prod);
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
		return true;
	}

	public boolean deleteProduct_Details(ProductDetails prod) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		ProductDetails pt = (ProductDetails) session.createCriteria(ProductDetails.class)
				.add(Restrictions.eq("id", prod.getId())).uniqueResult();
		Transaction tx = session.beginTransaction();
		session.delete(pt);
		tx.commit();
		session.close();
		
		return true;
	}

	public boolean updateProduct_Details(ProductDetails prod) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ProductDetails pt =(ProductDetails) sessionFactory.getCurrentSession().get(ProductDetails.class, prod.getId()); 
//		pt.setProduct_details_type_id(prod.getProduct_details_type_id());
//		pt.setProduct_details_attribute_id(prod.getProduct_details_attribute_id());
		tx.commit();
		session.close();
		return true;
	}

	public List<ProductDetails> getAllProduct_Details() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from ProductDetails");
		List<ProductDetails> plist = q.list();
		return plist;
	
	}
}

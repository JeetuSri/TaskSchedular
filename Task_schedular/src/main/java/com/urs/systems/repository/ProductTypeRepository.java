package com.urs.systems.repository;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.urs.systems.model.ProductType;


@Repository
@Transactional
public class ProductTypeRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean updateProductType(ProductType pro) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		ProductType pt =(ProductType) sessionFactory.getCurrentSession().get(ProductType.class, pro.getProduct_category_id()); 
		pt.setProduct_type(pro.getProduct_type());
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
		return true;
	}

	public boolean save(ProductType productType) {
		
		Session ss = sessionFactory.openSession();
		ProductType p = new ProductType();
		p.setProduct_type(productType.getProduct_type());
		ss.save(productType);
		Transaction tx = ss.beginTransaction();
		tx.commit();
		ss.close();
		return true;
	}



	public boolean deleteProducttype(ProductType prod) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		ProductType pt = (ProductType) session.createCriteria(ProductType.class)
				.add(Restrictions.eq("product_type_id", prod.getProduct_category_id())).uniqueResult();
		System.out.println(pt.getProduct_type());
		session.delete(pt);
		Transaction tx = session.beginTransaction();
        System.out.println("Object Deleted successfully.....!!");
        tx.commit();
        session.close();
        
		return true;
	}



	public List<ProductType> getProduct_type() {
		// TODO Auto-generated method stub
		List<ProductType> list = (List<ProductType>)sessionFactory.getCurrentSession().createQuery("From ProductType").list();
		List<ProductType> producttypes = new ArrayList();
		for(ProductType obj : list){
			obj.setProductDetails(null);
//			obj.setCategory(null);
			producttypes.add(obj);
		}
		return producttypes;
	}
		
}

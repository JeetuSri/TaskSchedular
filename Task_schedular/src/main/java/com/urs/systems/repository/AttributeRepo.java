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

import com.urs.systems.model.Attribute;
import com.urs.systems.model.ProductType;


@Repository
@Transactional
public class AttributeRepo {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean createAttributes(Attribute a) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Attribute attr = new Attribute();
		attr.setValue(a.getValue());
		attr.setAttribute(a.getAttribute());
		session.save(attr);
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
		return false;
	}

	public boolean updateAttributes(Attribute a) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Attribute apt =(Attribute) sessionFactory.getCurrentSession().get(Attribute.class, a.getAttribute_id()); 
		apt.setValue(a.getValue());
		apt.setAttribute(a.getAttribute());
		tx.commit();
		session.close();
		return true;
	}

	public boolean deleteAttributes(Attribute a) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Attribute attr = (Attribute) session.createCriteria(Attribute.class)
				.add(Restrictions.eq("attribute_id", a.getAttribute_id())).uniqueResult();
		Transaction tx = session.beginTransaction();
		session.delete(attr);
		tx.commit();
		session.close();
		return true;
	}

	public List<Attribute> getAllAttribute() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Attribute");
		List<Attribute> prodList = q.list();
		return prodList;
	}

		
}



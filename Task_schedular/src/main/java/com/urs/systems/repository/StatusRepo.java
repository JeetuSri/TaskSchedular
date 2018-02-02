package com.urs.systems.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.urs.systems.model.Status;

@Repository
@Transactional
public class StatusRepo implements StatusRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	private List<Status> status;
	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public List<Status> getAllStatus() {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		Query q = session.createQuery("from status");
		List<Status> statuslist= q.list();		
		return statuslist;
	}

	public List<Status> getApplicableStatus(String applicableTo) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();		
		List<Status> status = (List<Status>) session.createCriteria(Status.class).add(Restrictions.eq("applicable_to", applicableTo)).list();
		return status;
	}
	
	@Override
	public boolean save(Status status) {
		// TODO Auto-generated method stub
		Session ss = sessionFactory.openSession();
		Transaction tx = ss.beginTransaction();
		System.out.println(status);
		ss.save(status);
		tx.commit();
		ss.close();
		return true;
	}

	@Override
	public boolean updateStatus(Status status) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.openSession();
		  Transaction tx = session.beginTransaction();
		  Status Status =(Status) sessionFactory.getCurrentSession().get(Status.class, status.getStatusID()); 
		  Status.setStatusLabel(status.getStatusLabel());
		  Status.setApplicable_to(status.getApplicable_to());
		  Status.setRemark(status. getRemark());
		  Status.setDate_modified(status.getDate_modified());
		  Status.setLast_modified(status.getLast_modified());
		  tx.commit();
		  session.close();	  
		  return true;
	}

	@Override
	public boolean deleteStatus(Status status) {
		// TODO Auto-generated method stub
		  Session session = sessionFactory.openSession();
		  Status s = (Status) session.createCriteria(Status.class).add(Restrictions.eq("statusID", status.getStatusID())).uniqueResult();
		  Transaction tx = session.beginTransaction();
		  session.delete(s);
		  tx.commit();
		  session.close();
		  return true;
	}
}

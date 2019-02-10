package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	//need to inject the session factory -- sessionFactory is the bean id from spring-mvc-crud-demo-servlet.xml
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		//get the current Hibernate session
		Session session = sessionFactory.openSession();
		//create query
		Query<Customer> query = session.createQuery("from Customer order by last_name", Customer.class);
		//get results
		List<Customer> customers = query.getResultList();
		//return list of customers
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session session = sessionFactory.getCurrentSession();
		
		//save the customer to db
		session.save(theCustomer);
		
	}

}

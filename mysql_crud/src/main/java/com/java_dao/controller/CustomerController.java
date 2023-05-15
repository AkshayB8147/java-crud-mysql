package com.java_dao.controller;

//import java.util.ArrayList;
import java.util.List;

import com.java_dao.model.bean.Customer;
import com.java_dao.model.dao.CustomerDao;
import com.java_dao.model.daofactory.CustomerDaoImpl;

public class CustomerController {
	public List<Customer> getAllCustomers(){
		
		CustomerDao customerDao=new CustomerDaoImpl();
		return customerDao.getAllCustomers();
	}
	
	public Customer getById(int id) {
		CustomerDao customerDao=new CustomerDaoImpl();
		return customerDao.getById(id);
	}
	
	public String insert(int id, String name, String email, String phone, String address,String gender) {
		CustomerDao customerDao =new CustomerDaoImpl();
		Customer c=new Customer();
		c.setId(id);
		c.setName(name);
		c.setEmail(email);
		c.setPhone(phone);
		c.setAddress(address);
		c.setGender(gender);
		return customerDao.insertCustomer(c);
	}
	
	public String update(int id, String name, String email, String phone, String address,String gender) {
			CustomerDao customerDao =new CustomerDaoImpl();
			Customer c=new Customer();
			c.setId(id);
			c.setName(name);
			c.setEmail(email);
			c.setPhone(phone);
			c.setAddress(address);
			c.setGender(gender);
			return customerDao.updateCustomer(c);
	}
	
	public String delete(int id) {
		CustomerDao customerDao = new CustomerDaoImpl();
		return customerDao.deleteCustomer(id);
	}
}

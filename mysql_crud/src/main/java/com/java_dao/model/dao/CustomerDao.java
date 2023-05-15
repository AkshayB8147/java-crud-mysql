package com.java_dao.model.dao;

import java.util.List;

import com.java_dao.model.bean.Customer;

public interface CustomerDao {
	
	public List<Customer> getAllCustomers();
	public Customer getById(int id);
	public String insertCustomer(Customer customer);
	public String updateCustomer(Customer customer);
	public String deleteCustomer(int id);
	
}

package com.java_dao.app;

import com.java_dao.controller.CustomerController;
import com.java_dao.controller.CustomerFilterController;
import com.java_dao.model.bean.Customer;

public class App 
{
    public static void main( String[] args ){
    	CustomerController cc = new CustomerController();
    	System.out.println("started");

    	// Get All Customers
    	for(Customer c: cc.getAllCustomers()) {
    		System.out.println(c.getId()+", "+c.getName()+", "+c.getEmail()+", "+c.getPhone()+", "+c.getAddress()+", "+c.getGender());
    	}
    	
    	// Get Customer by Id
    	Customer c=cc.getById(11);
    	System.out.println(c.getId()+", "+c.getName()+", "+c.getEmail()+", "+c.getPhone()+", "+c.getAddress()+", "+c.getGender());
    	
    	// Insert a Customer
    	System.out.println(cc.insert(12, "Dharshan", "dharshan1998@gmail.com", "9519514568", "Hospet", "male"));
    	
    	// Update a customer
    	System.out.println(cc.update(12, "Darshan", "darshan1998@gmail.com", "9519514568", "hospet", "male"));
    	
    	// Delete a customer by id
    	System.out.println(cc.delete(12));
    	
    	//Search by name or email
    	CustomerFilterController customerSearch = new CustomerFilterController();
    	for(Customer cust: customerSearch.searchFilter("Akshay")) {
    		System.out.println(cust.getId()+", "+cust.getName()+", "+cust.getEmail()+", "+cust.getPhone()+", "+cust.getAddress()+", "+cust.getGender());
    	}
    	
    	System.out.println("end");
    }
}

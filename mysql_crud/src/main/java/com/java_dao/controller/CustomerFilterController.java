package com.java_dao.controller;

import java.util.List;

import com.java_dao.model.bean.Customer;
import com.java_dao.model.dao.CustomerFilterDao;
import com.java_dao.model.daofactory.CustomerFilterDaoImpl;

public class CustomerFilterController {
	public List<Customer> searchFilter(String filterItem){
		CustomerFilterDao customerFilterDao = new CustomerFilterDaoImpl();
		return customerFilterDao.searchFilter(filterItem);
	}
	
}

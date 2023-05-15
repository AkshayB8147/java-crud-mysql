package com.java_dao.model.dao;

import java.util.List;
import com.java_dao.model.bean.Customer;

public interface CustomerFilterDao {
//	public List<Customer> searchByName(String name);
//	public List<Customer> searchByEmail(String email);
//	public List<Customer> searchByNameAndEmail(String name, String email);
	public List<Customer> searchFilter(String filterItem);
}

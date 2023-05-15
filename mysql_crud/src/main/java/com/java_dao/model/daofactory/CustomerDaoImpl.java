package com.java_dao.model.daofactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.java_dao.conncetion.DataBaseConnection;
import com.java_dao.model.bean.Customer;
import com.java_dao.model.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao{
	
	private final String GET_ALL="SELECT * FROM CUSTOMER";
	private final String GET_BY_ID="SELECT * FROM CUSTOMER WHERE CUSTID=?";
	private final String INSERT_CUSTOMER="INSERT INTO CUSTOMER VALUES(?, ?, ?, ?, ?, ?)";
	private final String UPDATE_CUSTOMER="UPDATE CUSTOMER SET name=?, email=?, phone=?, address=?, gender=? WHERE custid=?";
	private final String DELETE_CUSTOMER="DELETE FROM CUSTOMER WHERE CUSTID=?";
	
	
	
	Connection con=DataBaseConnection.getConnection();
	
	
	/*
	 * Get all the customers 
	 * Return list of customer objects
	 */
	@Override
	public List<Customer> getAllCustomers() {
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Customer> customers = new ArrayList<Customer>();
		
		try {
			ps=con.prepareStatement(GET_ALL);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Customer customer=new Customer();
				customer.setId(rs.getInt("custid"));
				customer.setName(rs.getString("name"));
				customer.setEmail(rs.getString("email"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
				customer.setGender(rs.getString("gender"));
				customers.add(customer);
			}
			
		} catch(SQLException e) {
			System.out.println("Error executing query "+e);
		} finally {
			DataBaseConnection.closeConnection(con, ps, rs);
		}
		return customers;
	}

	/*
	 * Get a customer by ID
	 * return customer object
	 */
	@Override
	public Customer getById(int id) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer customer=null;
		try {
			ps=con.prepareStatement(GET_BY_ID);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			customer=new Customer();
			if(rs.next()) {
				customer.setId(rs.getInt("custid"));
				customer.setName(rs.getString("name"));
				customer.setEmail(rs.getString("email"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
				customer.setGender(rs.getString("gender"));
			}
		} catch (SQLException e) {
			System.out.println("Error executing query "+e);
		} finally {
			DataBaseConnection.closeConnection(con, ps, rs);
		}
		return customer;
	}

	/*
	 * Insert a customer
	 * return a string message on success 
	 */
	@Override
	public String insertCustomer(Customer customer) {
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(INSERT_CUSTOMER);
			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getPhone());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getGender());
			
			ps.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("Error executing query "+e);
		} finally {
			DataBaseConnection.closeConnection(con, ps);
		}
		return "Customer inserted successfully";
	}

	/*
	 * update a customer by using id
	 * return a message on success
	 */
	@Override
	public String updateCustomer(Customer customer) {
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(UPDATE_CUSTOMER);
			
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getPhone());
			ps.setString(4, customer.getAddress());
			ps.setString(5, customer.getGender());
			ps.setInt(6, customer.getId());
			
			ps.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("Error executing query "+e);
		} finally {
			DataBaseConnection.closeConnection(con, ps);
		}
		return "Customer Updated successfully";
	}

	/*
	 * Delete customer by ID
	 * return message on success
	 */
	@Override
	public String deleteCustomer(int id) {
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(DELETE_CUSTOMER);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("Error executing query "+e);
		} finally {
			DataBaseConnection.closeConnection(con, ps);
		}
		return "Customer deleted successfully";
	}
	
}

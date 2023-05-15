package com.java_dao.model.daofactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java_dao.conncetion.DataBaseConnection;
import com.java_dao.model.bean.Customer;
import com.java_dao.model.dao.CustomerFilterDao;

public class CustomerFilterDaoImpl implements CustomerFilterDao {
	
	String FILTER_QUERY="SELECT * FROM customer WHERE name LIKE ? OR email LIKE ?";
	
	Connection con=DataBaseConnection.getConnection();
	
	@Override
	public List<Customer> searchFilter(String filterItem) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Customer> customers= new ArrayList<Customer>();
		
		try {
			ps = con.prepareStatement(FILTER_QUERY);
			ps.setString(1, filterItem);
			ps.setString(2, filterItem);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Customer c= new Customer();
				c.setId(rs.getInt("custid"));
				c.setName(rs.getString("name"));
				c.setEmail(rs.getString("email"));
				c.setPhone(rs.getString("phone"));
				c.setAddress(rs.getString("address"));
				c.setGender(rs.getString("gender"));
				customers.add(c);
			}
		} catch(SQLException ex) {
			System.out.println("Query couldn't be executed " + ex);
		} finally {
			DataBaseConnection.closeConnection(con, ps, rs);
		}
		
		return customers;
	}
	
	

}

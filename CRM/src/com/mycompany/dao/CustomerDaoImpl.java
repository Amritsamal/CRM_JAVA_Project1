package com.mycompany.dao;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mycompany.domain.Customer;

public class CustomerDaoImpl implements ICustomerDao {
	
	@Override
	public void addCustomer(Customer customer) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","amritox","amr123");

			String sql = "insert into customer values (?,?,?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, customer.getId().intValue());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getAddress());
			preparedStatement.setString(5, customer.getCity());
			preparedStatement.setString(6, customer.getState());
			preparedStatement.setString(7, customer.getZip());

			preparedStatement.execute();

			System.out.println("Inserted Successfully.");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void updateCustomer(Customer customer) {
		
		Connection connection = null;
		try {
			 connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","amritox","amr123");
			
			String query = "update customer set email=? where name=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);				
			
			preparedStatement.setString(1, customer.getEmail());
			preparedStatement.setString(2, customer.getName());
						
			preparedStatement.execute();
			
			System.out.println("Record updated successfully....");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}

	@Override
	public List<Customer> findAllCustomers() {
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","amritox","amr123");

			String sqlQuery = "select * from customer";

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String address = resultSet.getString("address");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String zip = resultSet.getString("zip");

				Customer customer = new Customer();
				customer.setId(Long.valueOf(id));
				customer.setName(name);
				customer.setEmail(email);
				customer.setAddress(address);
				customer.setCity(city);
				customer.setState(state);
				customer.setZip(zip);

				customerList.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customerList;
	}

	@Override
	public void deleteCustomer(Long id) {
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","amritox","amr123");
			
			String search = "select * from customer where id=?";
			
			Statement statement = connection.createStatement();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public List<Customer> findCustomerByName(String name) {
		
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","amritox","amr123");

			String sqlQuery = "select * from customer where name = '" + name + "'";

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name1 = resultSet.getString("name");
				String email = resultSet.getString("email");
				String address = resultSet.getString("address");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String zip = resultSet.getString("zip");

				Customer customer = new Customer();
				customer.setId(Long.valueOf(id));
				customer.setName(name1);
				customer.setEmail(email);
				customer.setAddress(address);
				customer.setCity(city);
				customer.setState(state);
				customer.setZip(zip);

				customerList.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customerList;
	}

	@Override
	public Customer findCustomerById(int id) {		
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","amritox","amr123");

			String sqlQuery = "select * from customer where id = '" + id + "'";

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				int id1 = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String address = resultSet.getString("address");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String zip = resultSet.getString("zip");

				Customer customer = new Customer();
				customer.setId(Long.valueOf(id));
				customer.setName(name);
				customer.setEmail(email);
				customer.setAddress(address);
				customer.setCity(city);
				customer.setState(state);
				customer.setZip(zip);
				
				return customer;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Customer findCustomerByEmail(String email) {
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","amritox","amr123");

			String sqlQuery = "select * from customer where email = '" + email + "'";

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email1 = resultSet.getString("email");
				String address = resultSet.getString("address");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				String zip = resultSet.getString("zip");

				Customer customer = new Customer();
				customer.setId(Long.valueOf(id));
				customer.setName(name);
				customer.setEmail(email1);
				customer.setAddress(address);
				customer.setCity(city);
				customer.setState(state);
				customer.setZip(zip);
				
				return customer;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

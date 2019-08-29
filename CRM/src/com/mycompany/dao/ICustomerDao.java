package com.mycompany.dao;

import java.util.List;

import com.mycompany.domain.Customer;

public interface ICustomerDao {
	
	void addCustomer(Customer customer);

	void updateCustomer(Customer customer);

	List<Customer> findAllCustomers();

	void deleteCustomer(Long id);

	List<Customer> findCustomerByName(String name);

	Customer findCustomerById(int id);

	Customer findCustomerByEmail(String email);

}

package com.mycompany.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.mycompany.dao.CustomerDaoImpl;
import com.mycompany.domain.Customer;


public class CustomerService {
	
	public void getAllCustomers() {
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		List<Customer> customers = customerDaoImpl.findAllCustomers();

		for (Customer customer : customers) {
			System.out.println("ID:" + customer.getId());
			System.out.println("Name: " + customer.getName());
			System.out.println("Email: " + customer.getEmail());
			System.out.println("Address: " + customer.getAddress());
			System.out.println("City: " + customer.getCity());
			System.out.println("State: " + customer.getState());
			System.out.println("Zip: " + customer.getZip());
			System.out.println(" ");
		}

	}

	public void insertCustomerDetails() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter ID: ");		
		int id = 0;
		try {
			
			 id = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please enter ID in number format");
			
		}
		
		System.out.println("Enter Name: ");
		String name = scanner.next();

		System.out.println("Enter Email: ");
		String email = scanner.next();

		System.out.println("Enter Address: ");
		String address = scanner.next();

		System.out.println("Enter city: ");
		String city = scanner.next();

		System.out.println("Enter State: ");
		String state = scanner.next();

		System.out.println("Enter zip: ");
		String zip = scanner.next();

		Customer customer = new Customer();

		customer.setId(Long.valueOf(id));

		customer.setName(name);

		customer.setEmail(email);

		customer.setAddress(address);

		customer.setState(state);

		customer.setCity(city);

		customer.setZip(zip);

		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();

		customerDaoImpl.addCustomer(customer);
	}
	
	public void updateCustomerDetails() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter email to be replaced...");
		String email = scanner.next();
		
		System.out.println("Enter the name whose data to be replaced...");
		String name = scanner.next();
		
		Customer customer = new Customer();
		
		customer.setEmail(email);
		customer.setName(name);
		
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		
		customerDaoImpl.updateCustomer(customer);
		
	}
	
	public void findCustomerByName() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name :");
		String name = scanner.next();
		
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		
		List<Customer> customers = customerDaoImpl.findCustomerByName(name);
		
		for (Customer customer : customers) {
			System.out.println(customer.toString());
		}
	}
	
    public void findCustomerById() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id :");
		int id = scanner.nextInt();
		
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();	
		Customer customer = customerDaoImpl.findCustomerById(id);
		
		System.out.println(customer);
		
	}
    public void findCustomerByEmail() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the email :");
		String email = scanner.next();
		
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();	
		Customer customer = customerDaoImpl.findCustomerByEmail(email);
		
		System.out.println(customer);
		
	}
	
	

}

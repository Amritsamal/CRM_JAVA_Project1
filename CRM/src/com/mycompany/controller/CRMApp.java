package com.mycompany.controller;

import java.util.Scanner;

import com.mycompany.service.CustomerService;

public class CRMApp {

	public static void main(String[] args) {
		
		System.out.println("##########################");
		System.out.println("Customer Management System");
		System.out.println("###########################");

		System.out.println("Press 1 to add a record:");
		System.out.println("Press 2 to get all the records");
		System.out.println("Press 3 to update the records");
		System.out.println("Press 4 to get the records by name");
		System.out.println("Press 5 to get the records by id");
		System.out.println("Press 6 to get the records by email");

		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		CustomerService customerService = new CustomerService();
		if (choice == 1) {
			customerService.insertCustomerDetails();
		} else if (choice == 2) {
			customerService.getAllCustomers();
		} else if (choice == 3) {
			customerService.updateCustomerDetails();			
		} else if (choice == 4) {
			customerService.findCustomerByName();
		} else if (choice == 5) {
			customerService.findCustomerById();
		} else if (choice == 6) {
			customerService.findCustomerByEmail();
		} else {
			System.out.println("no operation..");
		}

	}

}

package com.bridgelabz.serviceimplementation;

import java.util.LinkedList;
import java.util.List;

import com.bridgelabz.model.Customer;
import com.bridgelabz.service.CustomerService;
import com.bridgelabz.utility.Utility;

public class CustomerServiceImplementation implements CustomerService {
	
	private static final String CUSTOMERS_FILE_NAME = "/home/administrator/javaprograms/commercialdataprocessing/src/com/bridgelabz/files/Customer.json";

	/**
	 * Function to show the list of the customers
	 * 
	 * @param customerList which contains the list of all the customers
	 */
	@Override
	public void showCustomerList(List<Customer> customerList) {
		List<Customer> listOfCustomer = new LinkedList<>();
		listOfCustomer = customerList;
		System.out.println("--------------------------");
		System.out.println("Customers list");
		System.out.println("--------------------------");
		for(int i=0; i<listOfCustomer.size(); i++) {
			System.out.println(listOfCustomer.get(i));
		}		
	}

	/**
	 * Function to add a new customer to the list
	 * 
	 * @param customerList which contains the list of the customer
	 * @return updated list of customers
	 */
	@Override
	public List<Customer> addCustomer(List<Customer> customerList) {
		List<Customer> newCustomerList = new LinkedList<>();
		newCustomerList = customerList;
		Customer customer = new Customer();
		System.out.println("Enter customer name:-");
		customer.setName(Utility.stringInput());
		System.out.println("Enter amount:-");
		customer.setAmount(Utility.integerInput());
		Utility.stringInput();
		customer.setId(customerList.size());
		newCustomerList.add(customer);
		System.out.println("Do you wish to save changes?  Enter Y/N");
		String choice = Utility.stringInput();
		if(choice.equalsIgnoreCase("Y")){
			Utility.javaObjectToJson(CUSTOMERS_FILE_NAME, newCustomerList);
			System.out.println("Changes saved");
			return newCustomerList;
		}
		else {
			System.out.println("Changes not saved");
			return customerList;
		}
	}

	/**
	 * FUnction to delete a customer from the list
	 * 
	 * @param customerList which contains the list of customers
	 * @param index contains the id of the customer to be deleted
	 * @return updated list of customers
	 */
	@Override
	public List<Customer> deleteCustomer(int index, List<Customer> customerList) {
		List<Customer> newCustomerList = new LinkedList<>();
		customerList.remove(index);
		newCustomerList = customerList;
		System.out.println("Do you wish to save changes?  Enter Y/N");
		String choice = Utility.stringInput();
		if(choice.equalsIgnoreCase("Y")){
			Utility.javaObjectToJson(CUSTOMERS_FILE_NAME, newCustomerList);
			System.out.println("Changes saved");
			return newCustomerList;
		}
		else {
			System.out.println("Changes not saved");
			return customerList;
		}
	}

	/**
	 * Function to update a customer details
	 * 
	 * @param index contains the id of the customer details to be updated
	 * @param customerList contains the list of customers
	 * @return list of updated customer's details
	 */
	@Override
	public List<Customer> updateCustomerDetails(int index, List<Customer> customerList) {
		List<Customer> newCustomerList = new LinkedList<>();
		Customer customer = new Customer();
		for(int i=0; i<customerList.size(); i++) {
			if(customerList.get(i).getId() == index) {
				customer = customerList.get(i);
				customerList.remove(i);
				break;
			}
		}
		Customer updateCustomer = new Customer();
		updateCustomer.setName(customer.getName());
		updateCustomer.setId(customer.getId());
		System.out.println("Update amount");
		updateCustomer.setAmount(Utility.integerInput());
		newCustomerList = customerList;
		newCustomerList.add(updateCustomer);
		System.out.println("Do you wish to save changes?  Enter Y/N");
		Utility.stringInput();
		String option = Utility.stringInput();
		if(option.equalsIgnoreCase("Y")) {
			Utility.javaObjectToJson(CUSTOMERS_FILE_NAME, newCustomerList);
			System.out.println("Changes saved");
			return newCustomerList;
		}
		else {
			System.out.println("Changes not saved");
			return customerList;
		}
	}
	
	/**
	 * Function to find a particular customer by name
	 * 
	 * @param name of the customer to be searched
	 * @param customerList contains the list of the customers
	 * @return a customer Object
	 */
	@Override
	public Customer searchCustomerByName(String name, List<Customer> customerList) {
		List<Customer> listOfCustomer = new LinkedList<>();
		Customer customer = new Customer();
		listOfCustomer = customerList;
		for(int i=0; i<listOfCustomer.size(); i++) {
			if(listOfCustomer.get(i).getName().equalsIgnoreCase(name)) {
				customer = listOfCustomer.get(i);
				break;
			}
		}
		return customer;
	}

}











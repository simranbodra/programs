package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.model.Customer;

public interface CustomerService {
	
	public void showCustomerList(List<Customer> customerList);
	public List<Customer> addCustomer(List<Customer> customerList);
	public List<Customer> deleteCustomer(int index, List<Customer> customerList);
	public List<Customer> updateCustomerDetails(int index, List<Customer> customerList);
	public Customer searchCustomerByName(String name, List<Customer> customerList);
	
}

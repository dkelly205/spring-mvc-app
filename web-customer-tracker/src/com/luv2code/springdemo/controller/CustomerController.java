package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDao;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	//need to inject the CustomerDao into this controller
	//spring will scan for a component that implements the CustomerDao interface
	//able to find it because of the Repository annotation
	@Autowired
	private CustomerDao customerDao;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		//get the customers from the dao
		List<Customer> customers = customerDao.getCustomers();
		//add the customers to the model
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}

}

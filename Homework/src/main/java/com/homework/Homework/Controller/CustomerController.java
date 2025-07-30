package com.homework.Homework.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homework.Homework.Entity.Customer;
import com.homework.Homework.Service.CustomerService;

@RestController
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	CustomerService customerSer;
	
	@GetMapping("/all")
	public List<Customer> getAllCustomers() {
        return customerSer.getAllCustomers();
    }
	
    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer c) {
        customerSer.addCustomer(c);
        return "Customer added!";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerSer.deleteCustomer(id);
        return "Customer deleted!";
    }
    
    //http://localhost:8080/customers/vote?customerId=1&markId=2
    @PostMapping("/vote")
    public String voteForMark(@RequestParam Long customerId, @RequestParam Long markId) {
        boolean success = customerSer.voteForMark(customerId, markId);
        if (success) {
            return "Vote recorded successfully!";
        } else {
            return "Vote failed: Customer or Mark not found.";
        }
    }
	
}

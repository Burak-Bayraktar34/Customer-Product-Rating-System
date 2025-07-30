package com.homework.Homework.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.Homework.Entity.Customer;
import com.homework.Homework.Entity.Mark;
import com.homework.Homework.Repository.CustomerRepository;
import com.homework.Homework.Repository.MarkRepository;

@Service
public class CustomerService {
	
	    @Autowired
	    CustomerRepository customerRepo;

	    @Autowired
	    MarkRepository markRepo;

	    
	    public List<Customer> getAllCustomers() {
	        return customerRepo.findAll();
	    }
	    
	    public void addCustomer(Customer customer) {
	        customerRepo.save(customer);
	    }

	    public void deleteCustomer(Long id) {
	    	  Optional<Customer> customerOpt = customerRepo.findById(id);
	    	    if (customerOpt.isPresent()) {
	    	        Customer customer = customerOpt.get();

	    	        if (customer.getAddingVote() != null) {
	    	            customer.getAddingVote().forEach(mark -> {
	    	                mark.setCustomer(null);
	    	                markRepo.save(mark); 
	    	            });
	    	        }

	    	        customerRepo.delete(customer); 
	    	    }
	    }

	    
	    public boolean voteForMark(Long customerId, Long markId) {
	    	
	        Optional<Customer> customerOpt = customerRepo.findById(customerId);
	        
	        Optional<Mark> markOpt = markRepo.findById(markId);

	        if (customerOpt.isPresent() && markOpt.isPresent()) {
	            Mark mark = markOpt.get();
	            // Oy sayısını 1 artır
	            mark.setTotalvote(mark.getTotalvote() + 1);
	            markRepo.save(mark);

	            // (İsteğe bağlı) müşteri markayı bir yerde tutmak isterse:
	            // Customer customer = customerOpt.get();
	            // customer.getAddingVote().add(mark);
	            // customerRepo.save(customer);

	            return true;
	        }

	        return false;
	    }

	

}

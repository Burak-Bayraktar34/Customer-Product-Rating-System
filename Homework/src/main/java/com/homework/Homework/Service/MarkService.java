package com.homework.Homework.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.Homework.Entity.Mark;
import com.homework.Homework.Repository.MarkRepository;

@Service
public class MarkService {
 
	@Autowired
	MarkRepository markRep;
	String output;
	
	public List<Mark>getAllMarks(){
		return markRep.findAll();
	}
	
	public String getAMark(Long id){
		output="";
		
		markRep.findAll().forEach(mark->{
			
		    if(mark.getMarkId() == id) {
		    	output+=mark.getMarkId()+" "+mark.getMarkName()+" "+mark.getTotalvote()+" ";
		    	mark.getProducts().forEach(product->{
		    		output+=product.getProductName()+" "+product.getProductPrice()+"<br>";
		    	});
		    		output+="<br>";
		    }
			
		});
		return output;

	}
	
	public void newMark(Mark m) {
		markRep.save(m);
	}
	
	public void removeMark(Long id) {
		markRep.deleteById(id);
	}
	
	
	
}

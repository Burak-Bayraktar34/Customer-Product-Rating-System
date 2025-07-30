package com.homework.Homework.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homework.Homework.Entity.Mark;
import com.homework.Homework.Service.MarkService;


@RestController
@RequestMapping("marks")
public class MarkController {
	
	   @Autowired
	    MarkService markSer;

	    @GetMapping("/all")
	    public List<Mark> getMarks() {
	        return markSer.getAllMarks();
	    }

	    @PostMapping("/add")
	    public String saveMark(@RequestBody Mark m) {
	        markSer.newMark(m);
	        return "New Mark Saved";
	    }

	    @DeleteMapping("/delete/{id}")
	    public String deleMark(@PathVariable Long id) {
	        markSer.removeMark(id);
	        return "Mark Deleted!";
	    }

	    @GetMapping("/{id}")
	    public String getMarkWithId(@PathVariable Long id) {
	        return markSer.getAMark(id);
	    }
	

}

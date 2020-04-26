package lk.nasi.CategoryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lk.nasi.CategoryService.model.Category;
import lk.nasi.CategoryService.service.CategoryService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	@RequestMapping(value="/category",method=RequestMethod.POST)
	 public Category create(@RequestBody Category category){
	    return service.insert(category);
	  }
	
	 @RequestMapping(value="/categories",method=RequestMethod.GET)
	  public List<Category> getAll(){
	    return service.getAll();
	  }
	 

}

package lk.nasi.ProductService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lk.nasi.ProductService.model.Product;
import lk.nasi.ProductService.service.ProductService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ProductController {

	@Autowired
	ProductService service;
	
	@RequestMapping(value="/product",method=RequestMethod.POST)
	 public Product create(@RequestBody Product product){
		
	    Product p= service.createOrUpdate(product);
	    System.out.println(p);
	    return p;
	  }
	
	 @RequestMapping(value="/product",method=RequestMethod.GET)
	  public List<Product> getAll(){
	    return service.getAll();
	  }
	 
	 @RequestMapping(value="/product/{id}",method=RequestMethod.GET)
	  public Optional<Product> get(@PathVariable int id){
	    return service.get(id);
	  }
	 
	 @RequestMapping(value="/product/{id}",method=RequestMethod.DELETE)
	  public  Optional<Product> delete(@PathVariable int id){
		 Optional<Product> p = service.get(id);
	       service.delete(id);
	       return p;
	  }
	
	 @RequestMapping(value="/updateProduct/{id}",method=RequestMethod.POST)
	 public Product update(@RequestBody Product product,@PathVariable("id") int id){
		 product.setId(id);
	    Product p= service.createOrUpdate(product);
	    System.out.println(p);
	    return p;
	  }
	
}

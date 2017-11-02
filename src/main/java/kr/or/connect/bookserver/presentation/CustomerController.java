package kr.or.connect.bookserver.presentation;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.bookserver.domain.Customer;
import kr.or.connect.bookserver.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	private final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	private final CustomerService service;
	
	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}
	
	@GetMapping
	Iterable<Customer> readList() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	Customer read(@PathVariable  Long id) {
		return service.findById(id);
	}
}

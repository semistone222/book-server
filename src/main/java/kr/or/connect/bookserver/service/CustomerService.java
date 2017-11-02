package kr.or.connect.bookserver.service;

import org.springframework.stereotype.Service;

import kr.or.connect.bookserver.domain.Customer;
import kr.or.connect.bookserver.persistence.CustomerRepository;

@Service
public class CustomerService {
	private CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Customer findById(Long id) {
		return customerRepository.findOne(id);
	}
	
	public Iterable<Customer> findAll() {
		return customerRepository.findAll();
	}
}

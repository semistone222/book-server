package kr.or.connect.bookserver.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.or.connect.bookserver.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	List<Customer> findByLastName(String lastName);
	
	List<Customer> findByFirstName(String firstName);
}

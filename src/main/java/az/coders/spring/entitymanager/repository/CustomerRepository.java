package az.coders.spring.entitymanager.repository;

import az.coders.spring.entitymanager.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

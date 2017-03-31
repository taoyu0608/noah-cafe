package noah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import noah.core.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

}

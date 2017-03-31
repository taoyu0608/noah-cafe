package noah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import noah.core.model.CustomerOrder;

public interface CustomerOrderDao extends JpaRepository<CustomerOrder, Long> {

}

package noah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import noah.core.model.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

}

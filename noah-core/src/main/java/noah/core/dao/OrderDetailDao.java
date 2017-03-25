package noah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import noah.core.model.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Long>{

}

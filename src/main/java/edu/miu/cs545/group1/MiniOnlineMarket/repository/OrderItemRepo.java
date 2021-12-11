package edu.miu.cs545.group1.MiniOnlineMarket.repository;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem,Long> {
}

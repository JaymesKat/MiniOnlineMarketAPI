package edu.miu.cs545.group1.MiniOnlineMarket.repository;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long>{

    @Query("SELECT o FROM Order o WHERE o.buyer = :buyer ORDER BY o.dateCreated DESC")
    public List<Order> findAllByBuyerOrderByDateCreatedDesc(Buyer buyer);
}

//package edu.miu.cs545.group1.MiniOnlineMarket.repository;
//
//import edu.miu.cs545.group1.MiniOnlineMarket.domain.OrderItem;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface OrderItemRepo extends JpaRepository<OrderItem,Long> {
//
//    @Query(value = "SELECT o FROM OrderItem o WHERE o.order_id = :orderId")
//    public List<OrderItem> findByOrderId(Long orderId);
//
//    @Query(value = "SELECT o FROM OrderItem o WHERE o.product_id = :itemId")
//    public OrderItem findByItemId(Long itemId);
//}

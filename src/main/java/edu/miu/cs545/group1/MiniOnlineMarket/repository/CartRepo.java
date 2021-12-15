package edu.miu.cs545.group1.MiniOnlineMarket.repository;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {

//    @Query(value = "SELECT c FROM Cart c WHERE c.owner.id = :ownerId")
//    public Optional<Cart> findByOwner(Long ownerId);

//    @Query(value = "SELECT c.items FROM Cart c WHERE c.owner.id = :ownerId ORDER BY c.dateCreated DESC")
//    List<Cart> findAllByUserOrderByCreatedDateDesc(Long ownerId);

//    @Modifying
//    @Query(value = "DELETE FROM Cart c WHERE c.owner = :user")
//    void deleteCart(Buyer user);
}

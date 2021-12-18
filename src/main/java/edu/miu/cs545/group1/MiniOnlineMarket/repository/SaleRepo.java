package edu.miu.cs545.group1.MiniOnlineMarket.repository;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepo extends JpaRepository <Sale,Long> {
    Integer countAllByProduct(Product product);

    @Query(value = "SELECT s FROM Seller s WHERE s.user.id = :sellerId")
    List<Sale> findBySeller(Long sellerId);
}

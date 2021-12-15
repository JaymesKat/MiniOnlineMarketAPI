package edu.miu.cs545.group1.MiniOnlineMarket.repository;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Cart;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.CartItem;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long> {
    @Query(value = "SELECT ci FROM CartItem ci WHERE ci.product = :product")
    public CartItem findByProduct(Product product);

    @Query(value = "SELECT ci FROM CartItem ci WHERE ci.cart = :cart")
    public CartItem findByCart(Cart cart);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM CartItem ci WHERE ci.product.id = :productId")
    void deleteByProductId(Long productId);
}

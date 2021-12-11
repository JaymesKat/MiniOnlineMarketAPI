package edu.miu.cs545.group1.MiniOnlineMarket.repository;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepo extends JpaRepository<ProductReview,Long> {
}

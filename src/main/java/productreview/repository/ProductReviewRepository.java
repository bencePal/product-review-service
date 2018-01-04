package productreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import productreview.model.ProductReview;

import java.util.List;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long>{

    List<ProductReview> findByProductId(@Param("productId") long id);
}

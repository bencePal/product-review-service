package productreview.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import productreview.model.ProductReview;
import productreview.repository.ProductReviewRepository;

import java.util.List;
import java.util.Map;


@RestController
public class ProductReviewRest {
    @Autowired
    private ProductReviewRepository productReviewRepository;

    @GetMapping("/{productId}")
    public ResponseEntity<List<ProductReview>> getAllReviewByProduct(
            @PathVariable("productId") long id) {
        return new ResponseEntity<>(productReviewRepository.findByProductId(id), HttpStatus.OK);
    }

    @PostMapping("/product-review")
    public ResponseEntity<String> addNewReview(
            @RequestParam Map<String,String> params) {
        System.out.println(params.keySet());
        System.out.println(params.values());
        return new ResponseEntity<>("Review add successful", HttpStatus.OK);
    }

}

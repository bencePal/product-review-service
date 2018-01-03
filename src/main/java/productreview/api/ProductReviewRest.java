package productreview.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import productreview.model.ProductReview;
import productreview.repository.ProductReviewRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ProductReviewRest {
    @Autowired
    private ProductReviewRepository productReviewRepository;

    @GetMapping("/{productId}")
    public ResponseEntity<Map<String, List<ProductReview>>> getAllReviewByProduct(
            @PathVariable("productId") long id) {
        Map reviewList = new HashMap();
        reviewList.put("reviewlist", productReviewRepository.findByProductId(id));
        return new ResponseEntity<Map<String, List<ProductReview>>>(reviewList, HttpStatus.OK);
    }

    @PostMapping("/product-review")
    public ResponseEntity<String> addNewReview(
            @RequestParam Map<String,String> params) {
        System.out.println(params.keySet());
        System.out.println(params.values());

        ProductReview productReview = new ProductReview();
        productReview.setProductId(Long.parseLong(params.get("productid")));
        productReview.setStar(Integer.parseInt(params.get("star")));
        productReview.setText(params.get("text"));
        productReview.setUserId(Long.parseLong(params.get("userid")));


        try {
            productReviewRepository.save(productReview);
            return new ResponseEntity<>("Review add successful", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Review add failed", HttpStatus.OK);
    }

}

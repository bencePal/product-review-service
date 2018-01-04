package productreview.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Map<String, String>> addNewReview(
            @RequestParam Map<String,String> params) {

        ProductReview productReview = new ProductReview();
        productReview.setProductId(Long.parseLong(params.get("productid")));
        productReview.setStar(Integer.parseInt(params.get("star")));
        productReview.setText(params.get("text"));
        productReview.setUserId(Long.parseLong(params.get("userid")));

        Map message = new HashMap();

        try {
            productReviewRepository.save(productReview);
            message.put("success", "Review add successful");
            return new ResponseEntity<Map<String, String>>(message, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        message.put("error", "Review add failed");
        return new ResponseEntity<Map<String, String>>(message, HttpStatus.OK);

    }

}

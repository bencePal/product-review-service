package productreview.model;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "ProductReview.findByProductId",
                query = "SELECT r FROM ProductReview r WHERE r.productId = :productId"
        )
})
@Entity
@Table(name = "PRODUCTREVIEW")
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "userid")
    private long userId;

    @Column(name = "productid")
    private long productId;

    private int star;

    private String text;

    public ProductReview() {
    }

    public ProductReview(long userId, long productId, int star, String text) {
        this.userId = userId;
        this.productId = productId;
        this.star = star;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

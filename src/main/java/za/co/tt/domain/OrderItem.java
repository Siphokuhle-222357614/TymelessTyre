package za.co.tt.domain;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class OrderItem {

    private Long productId;
    private int quantity;
    private BigDecimal price;
    private BigDecimal subtotal;

    public OrderItem() {}

    public OrderItem(Long productId, int quantity, BigDecimal price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = price.multiply(BigDecimal.valueOf(quantity));
    }


    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.subtotal = this.price.multiply(BigDecimal.valueOf(quantity));
    }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) {
        this.price = price;
        this.subtotal = price.multiply(BigDecimal.valueOf(this.quantity));
    }

    public BigDecimal getSubtotal() { return subtotal; }
}



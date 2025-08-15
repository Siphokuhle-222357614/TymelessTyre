/*Author: Bonke Bulana*/
package za.co.tt.domain;

public class CartItem {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemId;

    private int quantity;
    private double price;

    //    @ManyToOne
//    @JoinColumn(name = "cart_id")
    private Cart cart;

    //    @ManyToOne
//    @JoinColumn(name = "tyre_id")
    private Tyre tyre;

    //    @ManyToOne
//    @JoinColumn(name = "rim_id")
    private Rim rim;

    protected CartItem() {
    }

    private CartItem(Builder builder) {
        this.cartItemId = builder.cartItemId;
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.cart = builder.cart;
        this.tyre = builder.tyre;
        this.rim = builder.rim;
    }

    public long getCartItemId() {
        return cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Cart getCart() {
        return cart;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public Rim getRim() {
        return rim;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", quantity=" + quantity +
                ", price=" + price +
//                ", cartId=" + (cart != null ? cart.getId() : null) +
                ", tyreId=" + (tyre != null ? tyre.getId() : null) +
                ", rimId=" + (rim != null ? rim.getId() : null) +
                '}';
    }

    public static class Builder {
        private long cartItemId;
        private int quantity;
        private double price;
        private Cart cart;
        private Tyre tyre;
        private Rim rim;

        public Builder setCartItemId(long cartItemId) {
            this.cartItemId = cartItemId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder setTyre(Tyre tyre) {
            this.tyre = tyre;
            return this;
        }

        public Builder setRim(Rim rim) {
            this.rim = rim;
            return this;
        }

        public Builder copy(CartItem item) {
            this.cartItemId = item.cartItemId;
            this.quantity = item.quantity;
            this.price = item.price;
            this.cart = item.cart;
            this.tyre = item.tyre;
            this.rim = item.rim;
            return this;
        }

        public CartItem build() {
            return new CartItem(this);
        }
    }
}
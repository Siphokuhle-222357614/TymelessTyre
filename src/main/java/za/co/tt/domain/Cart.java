package za.co.tt.domain;

import jakarta.persistence.*;


@Entity
@Table(name="cart")
public class Cart {

    //Just placeholders to avoid errors, to be fixed by the owner of this entity..
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    public long getCartId() {
        return cartId;
    }
}

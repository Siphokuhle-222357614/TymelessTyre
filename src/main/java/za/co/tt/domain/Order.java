package za.co.tt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="order")
public class Order {

    //Just placeholders to avoid errors, to be fixed by the owner of this entity..
    @Id
    @GeneratedValue
    private Long orderId;


}

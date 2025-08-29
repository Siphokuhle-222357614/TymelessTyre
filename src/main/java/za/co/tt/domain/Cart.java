package za.co.tt.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;


@Entity
@Table(name="cart")
public class Cart {

    //Just placeholders to avoid errors, to be fixed by the owner of this entity..
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private boolean isActive;

    @JoinColumn(name = "userId")
    private User user;
    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;
   // private DomainValidator.Item item;


    public Cart() {
    }

    private Cart(Builder builder) {
        this.id = builder.id;
        this.createdAt = builder.createdAt;
        this.isActive = builder.isActive;
        this.user = builder.user;
        this.updatedAt = builder.updatedAt;
        this.item = builder.item;


    }

    public long getId() {
        return id;
    }

    public boolean getisActive() {
        return isActive;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
    public item getItem(){return item ;}


    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", user=" + user +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", Item=" + item +
                '}';
    }

    public static class Builder {
        private long id;
        private boolean isActive;
        private User user;
        private LocalDate createdAt;
        private LocalDate updatedAt;
        private item Item;
        //private quatity
    }

    public Builder setId(Long id) {
        this.id = id;
        return this;
    }

    public Builder setisActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    public Builder setUser(User user) {
        this.user = user;
        return this;
    }

    public Builder setCreatAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Builder setUpdatedAt(LocalDate updatedAtAt) {
        this.updatedAt = updatedAtAt;
        return this;
    }
    public Builder setItem(item Item){
        this.Builder = Item;
        return this;
    }

    public Builder copy(Cart cart) {
        this.id = cart.id;
        this.isActive = cart.isActive;
        this.user = cart.user;
        this.createdAt = cart.createdAt;
        this.updatedAt = cart.updatedAt;
        this.item  = cart.item;
        return this;
    }

    public Cart build(){ return new Cart(builder: this);}
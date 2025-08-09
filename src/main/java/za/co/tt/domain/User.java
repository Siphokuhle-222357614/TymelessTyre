package za.co.tt.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private String password;
    private String phone;

    @CreationTimestamp
    private LocalDate createdAt;

    private Boolean isAdmin = false;
    private Boolean isActive = true;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Payment> payments;


     @OneToMany(mappedBy = "user")
     private List<Order> orders;

     @OneToMany(mappedBy = "user")
     private List<Review> reviews;


      @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
      private Cart cart;


    public User(){

    }

    private User(Builder builder){
        this.userId= builder.userId;
        this.firstName= builder.firstName;
        this.lastName= builder.lastName;
        this.email= builder.email;
        this.password= builder.password;
        this.phone= builder.phone;
        this.createdAt = builder.createdAt;
        this.isAdmin = builder.isAdmin;
        this.isActive = builder.isActive;
        this.addresses = builder.addresses;
        this.payments = builder.payments;
        this.orders = builder.orders;
    }

    public Long getUserId() {

        return userId;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public Boolean getActive() {
        return isActive;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public List<Order> getOrders(){
        return orders;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", isAdmin=" + isAdmin +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                ", addresses=" + addresses +
                ", payments=" + payments +
                ", orders=" + orders +
                //more to be added
                '}';
    }

    public static class Builder{
        private Long userId;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String phone;
        private LocalDate createdAt;
        private Boolean isAdmin = false;
        private Boolean isActive = true;
        private List<Address> addresses;
        private List<Payment> payments;
        private List<Order> orders;



        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder setCreatedAt(LocalDate createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        public Builder setAdmin(Boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }
        public Builder setActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }
        public Builder setAddresses(List<Address> addresses) {
            this.addresses = addresses;
            return this;
        }
        public Builder setPayments(List<Payment> payments){
            this.payments = payments;
            return  this;
        }
        public Builder setOrder(List<Order> orders){
            this.orders = orders;
            return this;
        }
        public Builder copy(User user) {
            this.userId = user.userId;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.email = user.email;
            this.password = user.password;
            this.phone = user.phone;
            this.createdAt = user.createdAt;
            this.isAdmin = user.isAdmin;
            this.isActive = user.isActive;
            this.addresses = user.addresses;
            this.payments = user.payments;
            this.orders = user.orders;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
}

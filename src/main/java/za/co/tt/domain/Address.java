package za.co.tt.domain;

import jakarta.persistence.*;
import za.co.tt.domain.Enum.AddressType;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;


    @Enumerated(EnumType.STRING)
    private AddressType addressType;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Address() {
    }

    public Address(Builder builder) {
        this.addressId = builder.addressId;
        this.street = builder.street;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
        this.country = builder.country;
        this.addressType = builder.addressType;
    }

    public Long getAddressId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public User getUser() {
        return user;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", addressType='" + addressType + '\'' +
                ", user=" + user +
                '}';
    }

    public static class Builder {
        private Long addressId;
        private String street;
        private String city;
        private String state;
        private String postalCode;
        private String country;
        private AddressType addressType;
        private User user;

        public Builder setAddressId(Long addressId) {
            this.addressId = addressId;
            return this;
        }
        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }
        public Builder setCity(String city) {
            this.city = city;
            return this;
        }
        public Builder setState(String state) {
            this.state = state;
            return this;
        }
        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }
        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }
        public Builder setAddressType(AddressType addressType) {
            this.addressType = addressType;
            return this;
        }
        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(Address address) {
            this.addressId = address.addressId;
            this.street = address.street;
            this.city = address.city;
            this.state = address.state;
            this.postalCode = address.postalCode;
            this.country = address.country;
            this.user = address.user;
            return this;
        }
        public Address build() {
            return new Address(this);
        }
    }
}

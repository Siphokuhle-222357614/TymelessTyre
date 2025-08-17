/*Author: Bonke Bulana*/
package za.co.tt.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;

@Entity
@Table(name = "register")
public class Register {

    @Id
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean isAdmin;
    private Boolean isActive;

    @CreationTimestamp
    private LocalDate createdAt;

    public Register() {
    }

    private Register(Builder builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.isAdmin = builder.isAdmin;
        this.isActive = builder.isActive;
        this.createdAt = builder.createdAt;
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

    public Boolean getAdmin() {
        return isAdmin;
    }

    public Boolean getActive() {
        return isActive;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Register{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                '}';
    }

    public static class Builder {
        private Long userId;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private Boolean isAdmin;
        private Boolean isActive;
        private LocalDate createdAt;

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

        public Builder setAdmin(Boolean admin) {
            isAdmin = admin;
            return this;
        }

        public Builder setActive(Boolean active) {
            isActive = active;
            return this;
        }

        public Builder setCreatedAt(LocalDate createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder copy(Register register) {
            this.userId = register.userId;
            this.firstName = register.firstName;
            this.lastName = register.lastName;
            this.email = register.email;
            this.password = register.password;
            this.isAdmin = register.isAdmin;
            this.isActive = register.isActive;
            this.createdAt = register.createdAt;
            return this;
        }

        public Register build() {
            return new Register(this);
        }
    }
}

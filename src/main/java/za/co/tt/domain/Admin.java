package za.co.tt.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String username;

    private String email;

    private String role; // e.g., "ADMIN"

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    private Boolean isActive;

    // -------------------- Constructors --------------------
    public Admin() {
    }

    private Admin(Builder builder) {
        this.adminId = builder.adminId;
        this.username = builder.username;
        this.email = builder.email;
        this.role = builder.role;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.isActive = builder.isActive;
    }

    // -------------------- Getters --------------------
    public Long getAdminId() {
        return adminId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", isActive=" + isActive +
                '}';
    }

    // -------------------- Builder --------------------
    public static class Builder {
        private Long adminId;
        private String username;
        private String email;
        private String role;
        private LocalDate createdAt;
        private LocalDate updatedAt;
        private Boolean isActive;

        public Builder setAdminId(Long adminId) {
            this.adminId = adminId;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setCreatedAt(LocalDate createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setUpdatedAt(LocalDate updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder setIsActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder copy(Admin admin) {
            this.adminId = admin.adminId;
            this.username = admin.username;
            this.email = admin.email;
            this.role = admin.role;
            this.createdAt = admin.createdAt;
            this.updatedAt = admin.updatedAt;
            this.isActive = admin.isActive;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}

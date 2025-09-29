package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.tt.domain.Admin;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    /**
     * Optional helper: find all admins by role (ignoring case)
     * e.g., role = "ADMIN"
     */
    List<Admin> findByRoleIgnoreCase(String role);
}

package za.co.tt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.tt.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}

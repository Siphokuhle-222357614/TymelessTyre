/*LoginRequestRepository
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */

package za.co.tt.repository;

import org.springframework.stereotype.Repository;
import za.co.tt.domain.LoginRequest;


@Repository
public interface LoginRequsetRepository {

    LoginRequest findByEmailAndPassword(String email, String password);
}

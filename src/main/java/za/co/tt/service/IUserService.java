/*UserService
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */

package za.co.tt.service;

import za.co.tt.domain.User;
import za.co.tt.domain.UserRole;

import java.util.List;
import java.util.Optional;


public interface IUserService{
    User save(User user);

    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);
    List<User> findAllByRole(UserRole role);
    List<User> findAll();
    void deleteById(Long id);
    User update(Long id, User updatedUser);
}

/*Author: Bonke Bulana*/
package za.co.tt.factory;

import za.co.tt.domain.Register;
import za.co.tt.util.Helper;

import java.time.LocalDate;

public class RegisterFactory {

    public static Register createRegister(Long userId, String firstName, String lastName, String email, String password,
                                          Boolean isAdmin, Boolean isActive, LocalDate createdAt) {

        if (userId <= 0 || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password) ||
                isAdmin == null || isActive == null || createdAt == null) {
            return null;
        }

        return new Register.Builder()
                .setUserId(userId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setAdmin(isAdmin)
                .setActive(isActive)
                .setCreatedAt(createdAt)
                .build();
    }

}

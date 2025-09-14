package za.co.tt.factory;

import za.co.tt.domain.User;
import za.co.tt.util.Helper;

public class UserFactory {

    public static User createUser(String username, String email, String password, String role) {

        if (Helper.isNullOrEmpty(username)
                || Helper.isNullOrEmpty(password)
                || !Helper.isValidEmail(email) || Helper.isNullOrEmpty(role)) {

            return null;
        }

        return new User.Builder()
                .setUsername(username)
                .setEmail(email)
                .setPassword(password)
                .setRole(role)
                .build();
    }

    public static User createCustomer(String username, String email, String password) {
        return createUser(username, email, password, "CUSTOMER");
    }

    public static User createAdmin(String username, String email, String password) {
        return createUser(username, email, password, "ADMIN");
    }
}

package za.co.tt.factory;

import za.co.tt.domain.User;
import za.co.tt.util.Helper;

public class UserFactory {

    public static User createUser(String name,
                                  String surname,
                                  String username,
                                  String email,
                                  String password,
                                  String role) {

        if (Helper.isNullOrEmpty(username)
                || Helper.isNullOrEmpty(password)
                || !Helper.isValidEmail(email)
                || Helper.isNullOrEmpty(role)) {

            return null;
        }

        return new User.Builder()
                .setName(name)
                .setSurname(surname)
                .setUsername(username)
                .setEmail(email)
                .setPassword(password)
                .setRole(role)
                .build();
    }

    public static User createCustomer(String name,
                                      String surname,
                                      String username,
                                      String email,
                                      String password) {
        return createUser(name, surname, username, email, password, "CUSTOMER");
    }

    public static User createAdmin(String name,
                                   String surname,
                                   String username,
                                   String email,
                                   String password) {
        return createUser(name, surname, username, email, password, "ADMIN");
    }
}

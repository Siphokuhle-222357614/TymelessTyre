package za.co.tt.factory;

import za.co.tt.domain.User;
import za.co.tt.util.Helper;

public class UserFactory {

    public static User createUser(String username, String email, String password){
        if (Helper.isNullOrEmpty(username)
                || !Helper.isValidEmail(email)
                || !Helper.isNullOrEmpty(password)
                ||username.length() < 3 || username.length() >50
                ||password.length() < 6){

        }

        return new User.Builder()
                .setUsername(username)
                .setEmail(email)
                .setPassword(password)
                .build();
    }
}

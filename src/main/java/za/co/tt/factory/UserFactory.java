package za.co.tt.factory;

import za.co.tt.domain.Address;
import za.co.tt.domain.User;
import za.co.tt.util.Helper;

import java.time.LocalDate;
import java.util.List;



public class UserFactory {

    public static User createUser(Long userId, String firstName, String lastName, String email, String password,
                                  String phone,
                                  LocalDate createdAt, Boolean isAdmin, Boolean isActive,
                                  List<Address> addresses) {
        if (userId == null || Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) || !Helper.isValidEmail(email) ||
                Helper.isNullOrEmpty(password) || !Helper.isValidMobile(phone) ||
                createdAt == null ||
                isAdmin == null ||
                isActive == null || addresses == null ) {
            return null;
        }

        return new User.Builder()
                .setUserId(userId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setPhone(phone)
                .setCreatedAt(createdAt)
                .setAdmin(isAdmin)
                .setActive(isActive)
                .setAddresses(addresses)
                .build();
    }


    public static User createUser1(Long userId, String firstName, String lastName, String email, String password,
                                   String phone,
                                   LocalDate createdAt) {
        if (userId == null || Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) || !Helper.isValidEmail(email) ||
                Helper.isNullOrEmpty(password) || !Helper.isValidMobile(phone) ||
                createdAt == null)  {
            return null;
        }

        return new User.Builder()
                .setUserId(userId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setPhone(phone)
                .setCreatedAt(createdAt)
                .build();
    }



}




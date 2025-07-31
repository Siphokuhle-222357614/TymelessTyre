package za.co.tt.util;

import org.apache.commons.validator.routines.EmailValidator;

public class Helper {

    public static boolean isNullOrEmpty(String str) {

        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidPostalCode(int postalCode) {

        return postalCode >= 1000 && postalCode <= 9999;
    }

    public static boolean isValidStreetNumber(String streetNumber) {
        if (isNullOrEmpty(streetNumber)) return false;
        try {
            int num = Integer.parseInt(streetNumber);
            return num >= 1 && num <= 99999;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidErfNumber(int erfNumber) {

        return erfNumber >= 1 && erfNumber <= 99999;
    }

    public static boolean isValidUnitNumber(short unitNumber) {

        return unitNumber >= 1 && unitNumber <= 99999;
    }

    public static boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        if (validator.isValid(email)){
            return true;
        }else {
            return false;
        }
    }


    public static boolean isValidMobile(String phone) {
        if (isNullOrEmpty(phone)) return false;
        return phone.matches("^0[0-9]{9}$");
    }
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password != null && password.matches(passwordRegex);
    }


}
package za.co.tt.factory;

import za.co.tt.domain.Address;
import za.co.tt.domain.Enum.AddressType;
import za.co.tt.util.Helper;

public class AddressFactory {

    public static Address createAddress(String street,
                                        String city,
                                        String state,
                                        int postalCode,
                                        String country,
                                        AddressType addressType) {

        if (Helper.isNullOrEmpty(street)
                || Helper.isNullOrEmpty(city)
                || Helper.isNullOrEmpty(state)
                || !Helper.isValidPostalCode(postalCode)
                || Helper.isNullOrEmpty(country)
                || addressType == null) {
            return null;


        }

        return new Address.Builder()
                .setStreet(street)
                .setCity(city)
                .setState(state)
                .setPostalCode(postalCode)
                .setCountry(country)
                .setAddressType(addressType)
                .build();
    }
}

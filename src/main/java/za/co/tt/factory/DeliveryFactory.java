package za.co.tt.factory;

import za.co.tt.domain.Delivery;
import za.co.tt.util.Helper;
import java.time.LocalDateTime;

public class DeliveryFactory {

    public static Delivery createDelivery(Long addressId, String deliveryStatus,
                                          String courierName, LocalDateTime estimatedDeliveryDate) {

        if (addressId == null || estimatedDeliveryDate == null || Helper.isNullOrEmpty(deliveryStatus) || Helper.isNullOrEmpty(courierName)) {
            return null;
        }

        return new Delivery.Builder()
                .setAddressId(addressId)
                .setDeliveryStatus(deliveryStatus)
                .setCourierName(courierName)
                .setEstimatedDeliveryDate(estimatedDeliveryDate)
                .build();
    }
}

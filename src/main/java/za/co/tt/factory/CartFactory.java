package za.co.tt.factory;
import za.co.tt.domain.Cart;
import za.co.tt.domain.User;
import za.co.tt.util.Helper;

import java.time.LocalDate;
public class CartFactory {

        public static Cart createCart(Boolean isActive, User user,
                                      LocalDate createdAt, LocalDate updatedAt) {


            if (Helper.isNullOrEmpty(String.valueOf(isActive)) || Helper.isNullOrEmpty(String.valueOf(user))
                    || createdAt == null || createdAt.isAfter(LocalDate.now())
                    || updatedAt == null || createdAt.isAfter(LocalDate.now())) {
                return null;

            }


            return new Cart.Builder()

                    .setIsActive(isActive)
                    .setUser(user)
                    .setCreatedAt(createdAt)
                    .setUpdatedAt(updatedAt)
                    .build();
        }

    }


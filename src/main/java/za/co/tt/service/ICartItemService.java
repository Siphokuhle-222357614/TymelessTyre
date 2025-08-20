/*Author: Bonke Bulana - 220539995 */
package za.co.tt.service;

import za.co.tt.domain.CartItem;

import java.util.List;

public interface ICartItemService extends IService<CartItem, Long> {

    CartItem create(CartItem cartItem);

    CartItem read(Long cartItemId);

    CartItem update(CartItem cartItem);

    CartItem delete(Long cartItemId);

    List<CartItem> getAll();
}

package za.co.tt.service;

import za.co.tt.domain.Cart;

import java.util.List;

public interface ICartService extends IService<Cart,Long>{
    Cart createCart(Cart cart);
   List<Cart> getAllCarts();

}

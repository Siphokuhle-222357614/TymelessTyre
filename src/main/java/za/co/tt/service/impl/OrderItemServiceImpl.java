//// src/main/java/za/co/tt/service/impl/OrderItemService.java
//package za.co.tt.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import za.co.tt.domain.CartItem;
//import za.co.tt.domain.OrderItem;
//import za.co.tt.repository.CartItemRepository;
//import za.co.tt.repository.OrderItemRepository;
//import za.co.tt.service.IOrderItemService;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
//
//@Service
//public class OrderItemServiceImpl implements IOrderItemService {
//
//    private OrderItemRepository repository;
//
//    @Autowired
//    public OrderItemServiceImpl(OrderItemRepository repository) {
//        this.repository = repository;
//    }
//
//
//    @Override
//    public OrderItem create(OrderItem cartItem) {
//        return this.repository.save(cartItem);
//    }
//
//    @Override
//    public OrderItem read(Long orderItemId) {
//        return this.repository.findById(id).orElse(null);
//    }
//
//    @Override
//    public CartItem update(CartItem cartItem) {
//        if (this.repository.existsById(cartItem.getCartItemId()))
//            return this.repository.save(cartItem);
//        return null;
//    }
//
//    @Override
//    public CartItem delete(Long cartItemId) {
//        CartItem cartItem = read(cartItemId);
//        if (cartItem != null) {
//            this.repository.delete(cartItem);
//            return cartItem;
//        }
//        return null;
//    }
//
//    @Override
//    public List<CartItem> getAll() {
//        return this.repository.findAll();
//    }
//}

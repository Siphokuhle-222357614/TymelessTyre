//// src/main/java/za/co/tt/factory/OrderItemFactory.java
//package za.co.tt.factory;
//
//import za.co.tt.domain.OrderItem;
//
//import java.util.UUID;
//
//public class OrderItemFactory {
//
//   public static OrderItem createOrderItem(String description, double price, int quantity) {
//       String id = UUID.randomUUID().toString();
//       return new OrderItem.Builder()
//               .setId(id)
//               .setDescription(description)
//               .setPrice(price)
//               .setQuantity(quantity)
//               .build();
//   }
//}

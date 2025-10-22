// package za.co.tt.serviceTest;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.transaction.annotation.Transactional;
// import za.co.tt.domain.*;
// import za.co.tt.domain.Enum.Season;
// import za.co.tt.domain.Enum.VehicleType;
// import za.co.tt.service.IOrderService;
// import za.co.tt.service.IProductService;
// import za.co.tt.service.IUserService;

// import java.math.BigDecimal;
// import java.util.Arrays;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.*;

// @SpringBootTest
// @Transactional
// class InventoryManagementTest {

//     @Autowired
//     private IOrderService orderService;

//     @Autowired
//     private IProductService productService;

//     @Autowired
//     private IUserService userService;

//     private Product testProduct;
//     private User testUser;
// // 
//     @BeforeEach
//     void setUp() {
//         // Create a test product with stock
//         testProduct = new Product.Builder()
//                 .setProductName("Test Tire")
//                 .setProductModel("Test Model")
//                 .setWidth(225)
//                 .setAspectRatio(45)
//                 .setRimDiameter(17)
//                 .setSeason(Season.ALL_SEASON)
//                 .setVehicleType(VehicleType.SEDAN)
//                 .setProductPrice(100)
//                 .setStockQuantity(10) // Initial stock: 10 units
//                 .setDescription("Test tire for inventory management")
//                 .build();
        
//         testProduct = productService.createProduct(testProduct);

//         // Create a test user (assuming UserFactory exists)
//         testUser = new User();
//         testUser.setFirstName("Test");
//         testUser.setLastName("User");
//         testUser.setEmail("test@example.com");
//         testUser = userService.save(testUser);
//     }

//     @Test
//     void testSuccessfulOrderReducesStock() {
//         // Initial stock should be 10
//         assertEquals(10, testProduct.getStockQuantity());

//         // Create order for 3 items
//         OrderDto orderDto = new OrderDto();
//         orderDto.setUserId(testUser.getUserId());
//         orderDto.setStatus("pending");
//         orderDto.setTotalPrice(300.0);

//         OrderItem orderItem = new OrderItem();
//         orderItem.setProductId(testProduct.getProductId());
//         orderItem.setQuantity(3);
//         orderItem.setPrice(BigDecimal.valueOf(100));

//         orderDto.setOrderItems(Arrays.asList(orderItem));

//         // Create the order
//         Order createdOrder = orderService.createOrder(orderDto);
//         assertNotNull(createdOrder);

//         // Verify stock was reduced: 10 - 3 = 7
//         Product updatedProduct = productService.getProductById(testProduct.getProductId()).orElseThrow();
//         assertEquals(7, updatedProduct.getStockQuantity());
//     }

//     @Test
//     void testInsufficientStockPreventsOrder() {
//         // Try to order more than available stock
//         OrderDto orderDto = new OrderDto();
//         orderDto.setUserId(testUser.getUserId());
//         orderDto.setStatus("pending");
//         orderDto.setTotalPrice(1500.0);

//         OrderItem orderItem = new OrderItem();
//         orderItem.setProductId(testProduct.getProductId());
//         orderItem.setQuantity(15); // More than the 10 available
//         orderItem.setPrice(BigDecimal.valueOf(100));

//         orderDto.setOrderItems(Arrays.asList(orderItem));

//         // Should throw exception for insufficient stock
//         IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
//             () -> orderService.createOrder(orderDto));
        
//         assertTrue(exception.getMessage().contains("Insufficient stock"));
//         assertTrue(exception.getMessage().contains("Available: 10"));
//         assertTrue(exception.getMessage().contains("Requested: 15"));

//         // Verify stock was NOT reduced
//         Product unchangedProduct = productService.getProductById(testProduct.getProductId()).orElseThrow();
//         assertEquals(10, unchangedProduct.getStockQuantity());
//     }

//     @Test
//     void testOrderDeletionRestoresStock() {
//         // Create an order first
//         OrderDto orderDto = new OrderDto();
//         orderDto.setUserId(testUser.getUserId());
//         orderDto.setStatus("pending");
//         orderDto.setTotalPrice(400.0);

//         OrderItem orderItem = new OrderItem();
//         orderItem.setProductId(testProduct.getProductId());
//         orderItem.setQuantity(4);
//         orderItem.setPrice(BigDecimal.valueOf(100));

//         orderDto.setOrderItems(Arrays.asList(orderItem));

//         Order createdOrder = orderService.createOrder(orderDto);

//         // Verify stock was reduced: 10 - 4 = 6
//         Product productAfterOrder = productService.getProductById(testProduct.getProductId()).orElseThrow();
//         assertEquals(6, productAfterOrder.getStockQuantity());

//         // Delete the order
//         orderService.deleteOrder(createdOrder.getOrderId());

//         // Verify stock was restored: 6 + 4 = 10
//         Product productAfterDeletion = productService.getProductById(testProduct.getProductId()).orElseThrow();
//         assertEquals(10, productAfterDeletion.getStockQuantity());
//     }

//     @Test
//     void testOrderCancellationRestoresStock() {
//         // Create an order first
//         OrderDto orderDto = new OrderDto();
//         orderDto.setUserId(testUser.getUserId());
//         orderDto.setStatus("pending");
//         orderDto.setTotalPrice(200.0);

//         OrderItem orderItem = new OrderItem();
//         orderItem.setProductId(testProduct.getProductId());
//         orderItem.setQuantity(2);
//         orderItem.setPrice(BigDecimal.valueOf(100));

//         orderDto.setOrderItems(Arrays.asList(orderItem));

//         Order createdOrder = orderService.createOrder(orderDto);

//         // Verify stock was reduced: 10 - 2 = 8
//         Product productAfterOrder = productService.getProductById(testProduct.getProductId()).orElseThrow();
//         assertEquals(8, productAfterOrder.getStockQuantity());

//         // Cancel the order by updating status
//         createdOrder.setOrderStatus("cancelled");
//         orderService.updateOrder(createdOrder.getOrderId(), createdOrder);

//         // Verify stock was restored: 8 + 2 = 10
//         Product productAfterCancellation = productService.getProductById(testProduct.getProductId()).orElseThrow();
//         assertEquals(10, productAfterCancellation.getStockQuantity());
//     }

//     @Test
//     void testCanFulfillOrderMethod() {
//         OrderItem availableItem = new OrderItem();
//         availableItem.setProductId(testProduct.getProductId());
//         availableItem.setQuantity(5); // Less than 10 available

//         OrderItem unavailableItem = new OrderItem();
//         unavailableItem.setProductId(testProduct.getProductId());
//         unavailableItem.setQuantity(15); // More than 10 available

//         // Should be able to fulfill 5 items
//         assertTrue(orderService.canFulfillOrder(Arrays.asList(availableItem)));

//         // Should NOT be able to fulfill 15 items
//         assertFalse(orderService.canFulfillOrder(Arrays.asList(unavailableItem)));
//     }

//     @Test
//     void testGetAvailableStock() {
//         // Test getting available stock
//         assertEquals(10, orderService.getAvailableStock(testProduct.getProductId()));

//         // Test with non-existent product
//         assertEquals(0, orderService.getAvailableStock(999L));
//     }
// }
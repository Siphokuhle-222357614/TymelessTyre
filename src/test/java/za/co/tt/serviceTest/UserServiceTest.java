// package za.co.tt.serviceTest;

// import org.junit.jupiter.api.MethodOrderer;
// import org.junit.jupiter.api.Order;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.TestMethodOrder;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import za.co.tt.domain.RegisterRequest;
// import za.co.tt.domain.User;
// import za.co.tt.service.UserService;

// import java.util.Optional;

// import static org.junit.jupiter.api.Assertions.*;

// @SpringBootTest
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// public class UserServiceTest {

//     @Autowired
//     private UserService userService;

//     private static final RegisterRequest customerRequest = new RegisterRequest();
//     private static final RegisterRequest adminRequest = new RegisterRequest();

//     static {
//         customerRequest.setName("Bonke");
//         customerRequest.setSurname("Bulana");
//         customerRequest.setUsername("BonkeBul");
//         customerRequest.setEmail("b.bulana@gmail.com");
//         customerRequest.setPhoneNumber("0782345678");
//         customerRequest.setPassword("bb123");
//         customerRequest.setConfirmPassword("bb123");
//         customerRequest.setRole("CUSTOMER");


//         adminRequest.setName("Sihle");
//         adminRequest.setSurname("Moor");
//         adminRequest.setUsername("Moor");
//         adminRequest.setEmail("s.moor@admin.com");
//         adminRequest.setPhoneNumber("0823456789");
//         adminRequest.setPassword("25adm");
//         adminRequest.setConfirmPassword("25adm");
//         adminRequest.setRole("ADMIN");
//     }

//     private static User customer;
//     private static User admin;

//     @Test
//     @Order(1)
//     void a_register() {
//         customer = userService.register(customerRequest);
//         admin = userService.register(adminRequest);

//         assertNotNull(customer);
//         assertEquals("CUSTOMER", customer.getRole());
//         assertNotNull(admin);
//         assertEquals("ADMIN", admin.getRole());

//         System.out.println("Registered Customer: " + customer);
//         System.out.println("Registered Admin: " + admin);
//     }

//     @Test
//     @Order(2)
//     void b_read() {
//         Optional<User> optionalCustomer = userService.findByEmail(customer.getEmail());
//         Optional<User> optionalAdmin = userService.findByEmail(admin.getEmail());

//         assertTrue(optionalCustomer.isPresent());
//         assertEquals("CUSTOMER", optionalCustomer.get().getRole());
//         assertTrue(optionalAdmin.isPresent());
//         assertEquals("ADMIN", optionalAdmin.get().getRole());

//         System.out.println("Read Customer: " + optionalCustomer.get());
//         System.out.println("Read Admin: " + optionalAdmin.get());
//     }

//     @Test
//     @Order(3)
//     void c_update() {
//         User updatedCustomer = new User.Builder()
//                 .copy(customer)
//                 .setPassword("bb029")
//                 .build();

//         User updatedAdmin = new User.Builder()
//                 .copy(admin)
//                 .setPassword("5adm")
//                 .build();

//         User savedCustomer = userService.save(updatedCustomer);
//         User savedAdmin = userService.save(updatedAdmin);

//         assertEquals("bb029", savedCustomer.getPassword());
//         assertEquals("5adm", savedAdmin.getPassword());

//         System.out.println("Updated Customer: " + savedCustomer);
//         System.out.println("Updated Admin: " + savedAdmin);

//         customer = savedCustomer;
//         admin = savedAdmin;
//     }

//     @Test
//     @Order(4)
//     void d_login() {
//         Optional<User> customerLogin = userService.login(customer.getUsername(), customer.getPassword());
//         Optional<User> adminLogin = userService.login(admin.getUsername(), admin.getPassword());

//         assertTrue(customerLogin.isPresent());
//         assertEquals("CUSTOMER", customerLogin.get().getRole());
//         assertTrue(adminLogin.isPresent());
//         assertEquals("ADMIN", adminLogin.get().getRole());

//         System.out.println("Customer login successful: " + customerLogin.get());
//         System.out.println("Admin login successful: " + adminLogin.get());
//     }

//     @Test
//     @Order(5)
//     void e_delete() {
//         userService.deleteById(customer.getUserId());
//         userService.deleteById(admin.getUserId());

//         Optional<User> deletedCustomer = userService.findByEmail(customer.getEmail());
//         Optional<User> deletedAdmin = userService.findByEmail(admin.getEmail());

//         assertFalse(deletedCustomer.isPresent());
//         assertFalse(deletedAdmin.isPresent());
//     }
// }

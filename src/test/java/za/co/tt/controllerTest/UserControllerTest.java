// package za.co.tt.controllerTest;

// import org.junit.jupiter.api.MethodOrderer;
// import org.junit.jupiter.api.Order;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.TestMethodOrder;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.*;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import za.co.tt.domain.LoginRequest;
// import za.co.tt.domain.RegisterRequest;
// import za.co.tt.domain.User;

// import static org.junit.jupiter.api.Assertions.*;

// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// public class UserControllerTest {

//     @Autowired
//     private TestRestTemplate restTemplate;

//     private static User registeredUser;

//     private final String baseUrl = "/user";

//     @Test
//     @Order(1)
//     void registerUser() {
//         RegisterRequest request = new RegisterRequest();
//         request.setName("Johns");
//         request.setSurname("Brutus");
//         request.setUsername("BrutusJ");
//         request.setEmail("unique002@gmail.com");
//         request.setPhoneNumber("0782974196");
//         request.setPassword("Pass5432!");
//         request.setConfirmPassword("Pass5432!");
//         request.setRole("CUSTOMER");

//         ResponseEntity<User> response = restTemplate.postForEntity(
//                 baseUrl + "/register", request, User.class
//         );

//         assertEquals(HttpStatus.CREATED, response.getStatusCode());
//         assertNotNull(response.getBody());
//         assertEquals("CUSTOMER", response.getBody().getRole());
//         assertEquals("Johns", response.getBody().getName());
//         assertEquals("Brutus", response.getBody().getSurname());
//         assertEquals("0782974196", response.getBody().getPhoneNumber());

//         registeredUser = response.getBody();
//         System.out.println("Registered user: " + registeredUser);
//     }

//     @Test
//     @Order(2)
//     void loginUser() {
//         assertNotNull(registeredUser, "Registered user must not be null");

//         LoginRequest loginRequest = new LoginRequest();
//         loginRequest.setUsername(registeredUser.getUsername());
//         loginRequest.setPassword("Pass5432!");

//         ResponseEntity<String> response = restTemplate.postForEntity(
//                 baseUrl + "/login", loginRequest, String.class
//         );

//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         assertNotNull(response.getBody());
//         assertTrue(response.getBody().contains("/customer/dashboard"));
//         System.out.println("Login response: " + response.getBody());
//     }

//     @Test
//     @Order(3)
//     void createAdminUser() {
//         User user = new User.Builder()
//                 .setName("Admin11")
//                 .setSurname("User1")
//                 .setUsername("JackAdmin")
//                 .setEmail("admin01@gmail.com")
//                 .setPhoneNumber("069925494")
//                 .setPassword("AdminPass322")
//                 .setRole("ADMIN")
//                 .build();

//         ResponseEntity<User> response = restTemplate.postForEntity(
//                 baseUrl + "/create", user, User.class
//         );

//         assertEquals(HttpStatus.CREATED.value(), response.getStatusCodeValue());
//         assertNotNull(response.getBody());
//         assertEquals("ADMIN", response.getBody().getRole());
//         assertEquals("Admin11", response.getBody().getName());
//         assertEquals("User1", response.getBody().getSurname());
//         assertEquals("069925494", response.getBody().getPhoneNumber());
//         System.out.println("Created admin user: " + response.getBody());
//     }
// }

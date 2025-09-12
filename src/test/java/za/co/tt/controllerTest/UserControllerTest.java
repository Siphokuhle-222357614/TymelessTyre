package za.co.tt.controllerTest;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.co.tt.domain.User;
import za.co.tt.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerTest {

    private static final User user = UserFactory.createUser(
            "Bulo",
            "bulo@gmail.com",
            "password100");


    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseUrl = "http://localhost:8080/user";

    @Test
    void createUser() {
        String url = baseUrl + "/create";
        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, user, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        User savedUser = postResponse.getBody();
        assertNotNull(savedUser.getUserId(), "UserId should be generated and not null");
        System.out.println("Saved user: " + savedUser);
    }



    @Test
    void readUser() {
        String url = baseUrl + "/read/" + user.getUserId();
        System.out.println("URL: " + url);
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        assertNotNull(response.getBody());
        assertEquals(user.getUserId(), response.getBody().getUserId());
        System.out.println(response.getBody());
    }

    @Test
    void updateUser() {
        User updated = new User.Builder().copy(user).setUsername("Rowen").build();
        String url = baseUrl + "/update";
        System.out.println("URL: " + url);
        System.out.println("Updated user: " + updated);
        ResponseEntity<User> response = restTemplate.postForEntity(url, updated, User.class);
        assertNotNull(response.getBody());
    }

    @Test
    void deleteUser() {
        String url = baseUrl + "/delete/" + user.getUserId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void getAllUsers() {
        String url = baseUrl + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all users: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
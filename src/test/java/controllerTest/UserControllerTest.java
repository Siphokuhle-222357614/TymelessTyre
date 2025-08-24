/*
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */
package controllerTest;
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
import za.co.tt.Main;
import za.co.tt.domain.User;
import za.co.tt.domain.UserRole;
import za.co.tt.factory.UserFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    private static User user = UserFactory.createUser(
            1001L, "Yanga", "Jilaji", "yjilaji@gmail.com", "pass123", "0682941085",
            LocalDate.now(), true, null, null, UserRole.CUSTOMER);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseUrl = "http://localhost:8080/user";

    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, user, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        User savedUser = postResponse.getBody();
        assertEquals(user.getUserId(), savedUser.getUserId());
        System.out.println("Saved user: " + savedUser);
    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + user.getUserId();
        System.out.println("URL: " + url);
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        assertEquals(user.getUserId(), response.getBody().getUserId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        User updated = new User.Builder().copy(user).setFirstName("Lihle").build();
        String url = baseUrl + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<User> response = restTemplate.postForEntity(url, updated, User.class);
        assertNotNull(response.getBody());
        assertEquals("Lihle", response.getBody().getFirstName());
        System.out.println("Updated user: " + response.getBody());
    }

    @Test
    void d_getAll() {
        String url = baseUrl + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    void e_delete() {
        String url = baseUrl + "/delete/" + user.getUserId();
        System.out.println("URL: " + url);

        restTemplate.delete(url);

        String readUrl = baseUrl + "/read/" + user.getUserId();
        ResponseEntity<User> response = restTemplate.getForEntity(readUrl, User.class);

        assertNull(response.getBody(), "User should be deleted and not found!");
        System.out.println("Deleted user with ID: " + user.getUserId());
    }
}




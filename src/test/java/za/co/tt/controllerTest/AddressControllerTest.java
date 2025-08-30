/*
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */
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
import za.co.tt.Main;
import za.co.tt.domain.Address;
import za.co.tt.factory.AddressFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressControllerTest {

    private static Address address = AddressFactory.createAddress(
            110L, "St Marks Road", "Cape Town", "Western Cape", 8001,
            "South Africa", true, null, LocalDate.now(), LocalDate.now());

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseUrl = "http://localhost:8080/address";

    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Address> postResponse = restTemplate.postForEntity(url, address, Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Address savedAddress = postResponse.getBody();
        assertEquals(address.getId(), savedAddress.getId());
        System.out.println("Saved address: " + savedAddress);
    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + address.getId();
        System.out.println("URL: " + url);
        ResponseEntity<Address> response = restTemplate.getForEntity(url, Address.class);
        assertEquals(address.getId(), response.getBody().getId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Address updated = new Address.Builder().copy(address).setCity("Johannesburg").build();
        String url = baseUrl + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Address> response = restTemplate.postForEntity(url, updated, Address.class);
        assertNotNull(response.getBody());
        assertEquals("Johannesburg", response.getBody().getCity());
        System.out.println("Updated address: " + response.getBody());
    }

    @Test
    void d_delete() {
        String url = baseUrl + "/delete/" + address.getId();
        restTemplate.delete(url);

        ResponseEntity<Address> response = restTemplate.getForEntity(baseUrl + "/read/" + address.getId(), Address.class);
        assertNull(response.getBody());
        System.out.println("Deleted address with ID: " + address.getId());
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
}



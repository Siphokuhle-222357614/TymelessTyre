/*LoginRequestFactoryTest
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */

package factoryTest;

import org.junit.jupiter.api.Test;
import za.co.tt.domain.LoginRequest;
import za.co.tt.factory.LoginRequestFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginRequestFactoryTest {

    private static LoginRequest loginReq = LoginRequestFactory.createLoginRequest("yentel@gmail.com",
            "Yentel@2025");

    private static LoginRequest loginReq1 = LoginRequestFactory.createLoginRequest(
            "lazola.gmail.com", "Lazola@99");
    private static LoginRequest loginReq2 = LoginRequestFactory.createLoginRequest("brandon@gmail.com",
            "brandon2002");

    @Test
    public void createTestThatEmailFails(){
        assertNotNull(loginReq1);
        System.out.println(loginReq1.toString());
    }
    @Test
    public void TestThatPasswordFails(){
        assertNotNull(loginReq2);
        System.out.println(loginReq2);
    }
    @Test
    public void createTestThatPasses(){
        assertNotNull(loginReq);
        System.out.println(loginReq);
    }

}


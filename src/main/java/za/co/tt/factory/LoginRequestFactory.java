/*LoginRequestFactory
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */

package za.co.tt.factory;

import za.co.tt.domain.LoginRequest;
import za.co.tt.util.Helper;

public class LoginRequestFactory {

    public static LoginRequest createLoginRequest( String email, String password){

        if (!Helper.isValidEmail(email) || !Helper.isValidPassword(password)){
            return null;
        }

        return new LoginRequest.Builder()
                .setEmail(email)
                .setPassword(password)
                .build();
    }
}


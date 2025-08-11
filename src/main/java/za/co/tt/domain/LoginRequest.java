/*LoginRequest Domain(Builder)
 * Author: Yanga Jilaji
 * Student number: 222582731
 * */

package za.co.tt.domain;

public class LoginRequest {

    private String email;
    private String password;

    public LoginRequest(){

    }

    private LoginRequest(Builder builder){
        this.email= builder.email;
        this.password= builder.password;
    }

    public String getEmail() {

        return email;
    }
    public String getPassword() {

        return password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private String email;
        private String password;

        public Builder setEmail(String email){
            this.email=email;
            return this;
        }
        public Builder setPassword(String password){
            this.password=password;
            return this;
        }


        public Builder copy(LoginRequest loginRequest){
            this.email= loginRequest.email;
            this.password= loginRequest.password;
            return this;

        }

        public LoginRequest build(){

            return new LoginRequest(this);
        }

    }
}


package api_tests.Login;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginSuccessful {
    private final String token;
    private final UserDetails userDetails;

    @JsonCreator
    public LoginSuccessful(@JsonProperty("token") String token,
                       @JsonProperty("userDetails") UserDetails userDetails) {
        this.token = token;
        this.userDetails = userDetails;
    }

    public String getToken() {
        return token;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }
}


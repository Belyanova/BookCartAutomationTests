package api_tests.Login;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails {
    private final Integer userId;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String password;
    private final String gender;
    private final Integer userTypeId;

    public UserDetails(@JsonProperty("userId") Integer userId,
                       @JsonProperty("firstName") String firstName,
                       @JsonProperty("lastName") String lastName,
                       @JsonProperty("username") String username,
                       @JsonProperty("password") String password,
                       @JsonProperty("gender") String gender,
                       @JsonProperty("userTypeId") Integer userTypeId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.userTypeId = userTypeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }
}

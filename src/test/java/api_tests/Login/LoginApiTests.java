package api_tests.Login;

import api_tests.Specifications.Specifications;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginApiTests {
    private final static String url = PropertyReader.getURL();

    @Test(description = "Login Successful API Test", alwaysRun = true)
    public void loginSuccessfulPostApiTest(){
        Specifications.installSpecification(Specifications.requestSpecification(url),
                Specifications.responseSpecificationOK200());
        Integer expectedUserId = 15;
        LoginData user = new LoginData(15, "String","String","String",
                "String","String", 2);
        LoginSuccessful loginSuccessful = given()
                .filter(new AllureRestAssured())
                .body(user)
                .when()
                .post("/api/Login")
                .then().log().all()
                .extract().as(LoginSuccessful.class);
        Integer userId = loginSuccessful.getUserDetails().getUserId();
        Assert.assertNotNull(loginSuccessful.getToken());
        Assert.assertNotNull(loginSuccessful.getUserDetails().getUserId());
        Assert.assertEquals(expectedUserId, userId);
    }

    @Test(description = "Login UnSuccessful API Test", alwaysRun = true)
    public void loginUnSuccessfulPostApiTest(){
        Specifications.installSpecification(Specifications.requestSpecification(url),
                Specifications.responseSpecificationERROR401());
        LoginData user = new LoginData(1912, "String","String","TestUser",
                "String","String", 2);
        Response response = given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/api/Login");

        response.then().statusCode(401);

        response.then().body(equalTo(""));
    }
}
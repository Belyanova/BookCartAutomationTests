package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void successfulLoginTest(){
        generalSteps.verifyGeneralPage()
                .goToLoginPage()
                .verifyLoginPage()
                .verifyErrorsAboutRequired()
                .fillUsernameAndPasswordInputs();
                //.verifyUsername();
    }
}

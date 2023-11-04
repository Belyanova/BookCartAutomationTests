package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTests {
    @Parameters("correctUsername")
    @Test(description = "Correct Username And Correct Password Test")
    public void usernameIsNotAvailableRegistrationTest(String correctUsername) {
        generalSteps.verifyGeneralPageNoLoginAccount()
                .goToLoginPage()
                .verifyLoginPage()
                .clickOnRegistrationButton()
                .verifyRegistrationPage()
                .verifyRequiredFieldsErrors();
    }
}

package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static pages.BasePage.generateRandomEnglishString;
@Feature("Login Tests")
public class LoginTests extends BaseTests {
    @Parameters({"correctUsername", "correctPassword"})
    @Test(description = "Correct Username And Correct Password Test")
    public void correctUsernameAndCorrectPasswordTest(String correctUsername, String correctPassword) {
        generalSteps.verifyGeneralPageNoLoginAccount()
                .goToLoginPage()
                .verifyLoginPage()
                .fillUsernameAndPasswordInputs(correctUsername, correctPassword)
                .clickOnLoginButton()
                .verifyThatLoginPageClosed()
                .verifyThatUsernameExpected(correctUsername)
                .logoutOfAccount();
    }

    @Parameters("correctUsername")
    @Test(description = "Correct Username And Incorrect Password Test")
    public void correctUsernameAndIncorrectPasswordTest(String correctUsername) {
        String randomPassword = generateRandomEnglishString(10);
        generalSteps.verifyGeneralPageNoLoginAccount()
                .goToLoginPage()
                .verifyLoginPage()
                .fillUsernameAndPasswordInputs(correctUsername, randomPassword)
                .clickOnLoginButton()
                .verifyErrorOnLoginPage();
    }

    @Test(description = "Incorrect Username And Incorrect Password Test")
    public void incorrectUsernameAndIncorrectPasswordTest(){
        String randomPassword = generateRandomEnglishString(10);
        String randomUsername = generateRandomEnglishString(10);
        generalSteps.verifyGeneralPageNoLoginAccount()
                .goToLoginPage()
                .verifyLoginPage()
                .fillUsernameAndPasswordInputs(randomUsername, randomPassword)
                .clickOnLoginButton()
                .verifyErrorOnLoginPage();
    }
}
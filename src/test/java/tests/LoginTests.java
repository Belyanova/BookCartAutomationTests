package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static pages.BasePage.generateRandomEnglishString;

public class LoginTests extends BaseTests {
    @Parameters({"correctUsername", "correctPassword"})
    @Test
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
    @Test
    public void correctUsernameAndIncorrectPasswordTest(String correctUsername) {
        String randomPassword = generateRandomEnglishString(10);
        generalSteps.verifyGeneralPageNoLoginAccount()
                .goToLoginPage()
                .verifyLoginPage()
                .fillUsernameAndPasswordInputs(correctUsername, randomPassword)
                .clickOnLoginButton()
                .verifyErrorOnLoginPage();
    }

    @Test
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

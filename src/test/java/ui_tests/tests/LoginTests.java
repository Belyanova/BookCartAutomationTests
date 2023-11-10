package ui_tests.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static ui_tests.pages.BasePage.generateRandomEnglishString;

public class LoginTests extends BaseTests {

    @Parameters({"correctUsername", "correctPassword"})
    @Test(description = "Correct Username And Correct Password Test", alwaysRun = true)
    public void correctUsernameAndCorrectPasswordLoginTest(String correctUsername, String correctPassword) {
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
    @Test(description = "Correct Username And Incorrect Password Test", alwaysRun = true)
    public void correctUsernameAndIncorrectPasswordLoginTest(String correctUsername) {
        String randomPassword = generateRandomEnglishString(10);
        generalSteps.verifyGeneralPageNoLoginAccount()
                .goToLoginPage()
                .verifyLoginPage()
                .fillUsernameAndPasswordInputs(correctUsername, randomPassword)
                .clickOnLoginButton()
                .verifyErrorOnLoginPage();
    }

    @Test(description = "Incorrect Username And Incorrect Password Test", alwaysRun = true)
    public void incorrectUsernameAndIncorrectPasswordLoginTest(){
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
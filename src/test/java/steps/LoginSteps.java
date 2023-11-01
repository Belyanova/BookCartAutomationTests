package steps;

import pages.GeneralPage;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage();

    public LoginSteps verifyLoginPage(){
        loginPage.assertThatLoginTitleExpected();
        return this;
    }

    public GeneralSteps fillUsernameAndPasswordInputs(){
        loginPage.fillUsernameInput();
        loginPage.fillPasswordInput();
        loginPage.clickOnLoginButton();
        return new GeneralSteps();
    }

    public LoginSteps verifyErrorsAboutRequired(){
        loginPage.assertThatUsernameErrorExpected();
        loginPage.assertThatPasswordErrorExpected();
        return this;
    }
}

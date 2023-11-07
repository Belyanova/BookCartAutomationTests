package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage = new LoginPage();

    @Step("Verify Login Page")
    public LoginSteps verifyLoginPage(){
        loginPage.assertThatLoginTitleExpected();
        loginPage.verifyThatUsernameAndPasswordErrorDisplayed();
        loginPage.verifyThatUsernameAndPasswordError();
        return this;
    }

    @Step("Fill Username {0} And Password {1} Inputs")
    public LoginSteps fillUsernameAndPasswordInputs(String username, String password){
        loginPage.fillUsernameInput(username);
        loginPage.fillPasswordInput(password);
        return this;
    }

    @Step("Click On Login Button")
    public LoginSteps clickOnLoginButton(){
        loginPage.verifyLoginButton();
        loginPage.clickOnLoginButton();
        return this;
    }

    @Step("Verify Error On Login Page")
    public void verifyErrorOnLoginPage(){
        loginPage.verifyThatIncorrectUsernameOrPasswordErrorDisplayed();
        loginPage.verifyThatIncorrectUsernameOrPasswordError();
    }

    @Step("Verify That Login Page Closed")
    public GeneralSteps verifyThatLoginPageClosed(){
        loginPage.verifyThatIncorrectUsernameOrPasswordErrorIsNotDisplayed();
        return new GeneralSteps();
    }

    @Step("Click On Registration Button")
    public RegistrationSteps clickOnRegistrationButton(){
        loginPage.clickOnRegisterButton();
        loginPage.verifyRegisterButton();
        return new RegistrationSteps();
    }
}
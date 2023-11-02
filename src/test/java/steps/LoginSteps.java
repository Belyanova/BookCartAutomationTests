package steps;

import pages.LoginPage;

public class LoginSteps {
    private final LoginPage loginPage = new LoginPage();

    public LoginSteps verifyLoginPage(){
        loginPage.assertThatLoginTitleExpected();
        loginPage.verifyThatUsernameAndPasswordErrorDisplayed();
        return this;
    }

    public LoginSteps fillUsernameAndPasswordInputs(String username, String password){
        loginPage.fillUsernameInput(username);
        loginPage.fillPasswordInput(password);
        return this;
    }

    public LoginSteps clickOnLoginButton(){
        loginPage.clickOnLoginButton();
        return this;
    }

    public void verifyErrorOnLoginPage(){
        loginPage.verifyThatIncorrectUsernameOrPasswordErrorDisplayed();
    }

    public GeneralSteps verifyThatLoginPageClosed(){
        loginPage.verifyThatIncorrectUsernameOrPasswordErrorIsNotDisplayed();
        return new GeneralSteps();
    }
}
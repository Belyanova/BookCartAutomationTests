package steps;

import io.qameta.allure.Step;
import pages.GeneralPage;

public class GeneralSteps {
    private final GeneralPage generalPage = new GeneralPage();

    @Step("Verify General Page No Login Account")
    public GeneralSteps verifyGeneralPageNoLoginAccount(){
        generalPage.assertThatBookCartButtonExpected();
        generalPage.assertThatLoginButtonExpected();
        return this;
    }

    @Step("Go To Login Page")
    public LoginSteps goToLoginPage(){
        generalPage.assertThatLoginButtonExpected();
        generalPage.clickOnLoginButton();
        return new LoginSteps();
    }

    @Step("Verify That Username Expected")
    public GeneralSteps verifyThatUsernameExpected(String username){
        generalPage.verifyThatUsernameExpected(username);
        return this;
    }

    @Step("Logout Of Account")
    public void logoutOfAccount(){
        generalPage.clickOnLogoutButton();
        generalPage.assertThatLoginButtonExpected();
    }
}

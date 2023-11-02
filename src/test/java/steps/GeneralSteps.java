package steps;

import pages.GeneralPage;

public class GeneralSteps {
    private final GeneralPage generalPage = new GeneralPage();

    public GeneralSteps verifyGeneralPageNoLoginAccount(){
        generalPage.assertThatBookCartButtonExpected();
        generalPage.assertThatLoginButtonExpected();
        return this;
    }

    public LoginSteps goToLoginPage(){
        generalPage.assertThatLoginButtonExpected();
        generalPage.clickOnLoginButton();
        return new LoginSteps();
    }

    public GeneralSteps verifyThatUsernameExpected(String username){
        generalPage.verifyThatUsernameExpected(username);
        return this;
    }

    public void logoutOfAccount(){
        generalPage.clickOnLogoutButton();
        generalPage.assertThatLoginButtonExpected();
    }
}

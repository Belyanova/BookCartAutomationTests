package steps;

import pages.GeneralPage;

public class GeneralSteps {
    private GeneralPage generalPage = new GeneralPage();

    public GeneralSteps verifyGeneralPage(){
        generalPage.assertThatBookCartButtonExpected();
        generalPage.assertThatLoginButtonExpected();
        return this;
    }

    public LoginSteps goToLoginPage(){
        generalPage.assertThatLoginButtonExpected();
        generalPage.clickOnLoginButton();
        return new LoginSteps();
    }

    public GeneralSteps verifyUsername(){
        generalPage.verifyUsername();
        return this;
    }
}

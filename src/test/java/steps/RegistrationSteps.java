package steps;

import io.qameta.allure.Step;
import pages.RegistrationPage;

public class RegistrationSteps {
    private final RegistrationPage registrationPage = new RegistrationPage();

    @Step("Verify Registration Page")
    public RegistrationSteps verifyRegistrationPage(){
        registrationPage.verifyThatRegistrationPageDisplayed();
        return this;
    }

    @Step("Verify Required Fields Errors")
    public RegistrationSteps verifyRequiredFieldsErrors(){
        registrationPage.clickOnAllRequiredElements();
        registrationPage.verifyRequiredFieldsErrors();
        return this;
    }

    @Step("Fill All Fields")
    public RegistrationSteps fillAllFields(String firstName, String lastName, String username, String password){
        registrationPage.fillAllRequiredFields(firstName,lastName,username,password);
        return this;
    }
}

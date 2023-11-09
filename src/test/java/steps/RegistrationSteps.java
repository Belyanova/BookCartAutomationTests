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
    public RegistrationSteps verifyRequiredFieldsAfterClickErrors(){
        registrationPage.clickOnAllRequiredElements();
        verifyRequiredFieldsErrors();
        return this;
    }

    @Step("Fill All Fields")
    public RegistrationSteps fillAllFields(String firstName, String lastName, String username, String password, String confirmPassword){
        registrationPage.fillAllRequiredFields(firstName,lastName,username,password,confirmPassword);
        return this;
    }

    @Step("Verify Required Fields Errors")
    public RegistrationSteps verifyRequiredFieldsErrors(){
        registrationPage.verifyThatErrorDisplayed("usernameError");
        registrationPage.verifyMessageError("usernameError", "User Name is required");
        registrationPage.verifyThatErrorDisplayed("firstNameError");
        registrationPage.verifyMessageError("firstNameError", "First Name is required");
        registrationPage.verifyThatErrorDisplayed("lastNameError");
        registrationPage.verifyMessageError("lastNameError", "Last Name is required");
        registrationPage.verifyThatErrorDisplayed("PasswordErrors");
        registrationPage.verifyMessageError("PasswordErrors", "Password is required");
        return this;
    }

    @Step("Verify That Username And Password Errors Displayed")
    public RegistrationSteps verifyThatUsernameAndPasswordErrorsDisplayed(){
        registrationPage.verifyThatErrorDisplayed("usernameAndPasswordErrors");
        registrationPage.verifyMessageError("usernameError", "User Name is not available");
        registrationPage.verifyMessageError("PasswordErrors",
                "Password should have minimum 8 characters, at least 1 uppercase letter, 1 lowercase letter and 1 number");
        return this;
    }

    @Step("Verify That Passwords Errors Displayed")
    public RegistrationSteps verifyThatPasswordsErrorsDisplayed(){
        registrationPage.verifyThatErrorDisplayed("passwordError");
        registrationPage.verifyThatErrorDisplayed("confirmPasswordError");
        registrationPage.verifyMessageError("passwordError",
                "Password should have minimum 8 characters, at least 1 uppercase letter, 1 lowercase letter and 1 number");
        registrationPage.verifyMessageError("confirmPasswordError", "Password do not match");
        return this;
    }

    @Step("Select Radio Button Male")
    public RegistrationSteps selectRadioButtonMale(){
        registrationPage.selectRadioButtonMale();
        registrationPage.verifyRadioButtonMale();
        return this;
    }

    @Step("Select Radio Button Female")
    public RegistrationSteps selectRadioButtonFemale(){
        registrationPage.selectRadioButtonFemale();
        registrationPage.verifyRadioButtonFemale();
        return this;
    }

    @Step("Click On Registration Button")
    public RegistrationSteps clickOnRegistrationButton(){
        registrationPage.clickOnRegisterButton();
        return this;
    }

    @Step("Verify Required Fields Errors Is Not Displayed")
    public RegistrationSteps verifyRequiredFieldsErrorsIsNotDisplayed(){
        registrationPage.verifyThatErrorIsNotDisplayed("usernameError");
        registrationPage.verifyThatErrorIsNotDisplayed("firstNameError");
        registrationPage.verifyThatErrorIsNotDisplayed("lastNameError");
        registrationPage.verifyThatErrorIsNotDisplayed("PasswordErrors");
        registrationPage.clickOnRegisterButton();
        return this;
    }

    @Step("Verify Registration Page Has Been Closed")
    public LoginSteps verifyRegistrationPageHasBeenClosed(){
        registrationPage.verifyThatRegistrationPageIsNotDisplayed();
        return new LoginSteps();
    }
}
package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static pages.BasePage.generateRandomEnglishString;
import static pages.BasePage.generateRandomPassword;

@Feature("Registration Tests")
public class RegistrationTests extends BaseTests {
    @Parameters("correctUsername")
    @Test(description = "Username Is Not Available And Incorrect Password Registration Test")
    public void usernameIsNotAvailableAndIncorrectPasswordRegistrationTest(String correctUsername){
        String randomFirstName = generateRandomEnglishString(5);
        String randomLastName = generateRandomEnglishString(5);
        String randomPassword = generateRandomPassword(5);
        generalSteps.verifyGeneralPageNoLoginAccount()
                .goToLoginPage()
                .verifyLoginPage()
                .clickOnRegistrationButton()
                .verifyRegistrationPage()
                .verifyRequiredFieldsAfterClickErrors()
                .fillAllFields(randomFirstName,randomLastName,correctUsername,randomPassword,randomPassword)
                .selectRadioButtonMale()
                .verifyThatUsernameAndPasswordErrorsDisplayed();
    }

    @Test(description = "Username Is Unique Password Do Not Match Registration Test")
    public void usernameIsUniquePasswordDoNotMatchRegistrationTest(){
        String randomFirstName = generateRandomEnglishString(5);
        String randomLastName = generateRandomEnglishString(5);
        String randomUserName = generateRandomEnglishString(5);
        String randomPassword = generateRandomPassword(5);
        String randomConfirmPassword = generateRandomPassword(5);
        generalSteps.verifyGeneralPageNoLoginAccount()
                .goToLoginPage()
                .verifyLoginPage()
                .clickOnRegistrationButton()
                .verifyRegistrationPage()
                .verifyRequiredFieldsAfterClickErrors()
                .fillAllFields(randomFirstName,randomLastName,randomUserName,randomPassword,randomConfirmPassword)
                .selectRadioButtonFemale()
                .clickOnRegistrationButton()
                .verifyThatPasswordsErrorsDisplayed();
    }

    @Parameters("correctPassword")
    @Test(description = "Correct Username And Correct Password Registration Test")
    public void correctUsernameAndCorrectPasswordRegistrationTest(String correctPassword){
        String randomFirstName = generateRandomEnglishString(5);
        String randomLastName = generateRandomEnglishString(5);
        String randomUsername = generateRandomEnglishString(5);
        generalSteps.verifyGeneralPageNoLoginAccount()
                .goToLoginPage()
                .verifyLoginPage()
                .clickOnRegistrationButton()
                .verifyRegistrationPage()
                .verifyRequiredFieldsAfterClickErrors()
                .fillAllFields(randomFirstName,randomLastName,randomUsername,correctPassword,correctPassword)
                .selectRadioButtonMale()
                .verifyRequiredFieldsErrorsIsNotDisplayed()
                .verifyRegistrationPageHasBeenClosed()
                .verifyLoginPage()
                .fillUsernameAndPasswordInputs(randomUsername, correctPassword)
                .clickOnLoginButton()
                .verifyThatLoginPageClosed()
                .verifyThatUsernameExpected(randomUsername)
                .logoutOfAccount();
    }
}
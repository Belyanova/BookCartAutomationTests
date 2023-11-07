package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = "//button[contains(.,'Register')]")
    private WebElement registerButton;

    @FindBy(xpath = "//app-user-registration[contains(.,'User Registration')]")
    private WebElement registrationTitle;

    @FindBy(xpath = "//div/input[@data-placeholder='First name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//div/input[@data-placeholder='Last Name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//div/input[@data-placeholder='User Name']")
    private WebElement userNameInput;

    @FindBy(xpath = "//div/input[@data-placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div/input[@data-placeholder='Confirm Password']")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//mat-error[contains(.,'First Name is required')]")
    private WebElement firstNameError;

    @FindBy(xpath = "//mat-error[contains(.,'Last Name is required')]")
    private WebElement lastNameError;

    @FindBy(xpath = "//mat-error[contains(.,'User Name')]")
    private WebElement userNameError;

    @FindBy(xpath = "//mat-error[contains(.,'Password')]")
    private WebElement passwordError;

    @FindBy(xpath = "//mat-error[contains(.,'Password do not match')]")
    private WebElement confirmpasswordError;

    @FindBy(xpath = "//mat-radio-button[contains(.,'Female')]")
    private WebElement radioButtonFemale;

    @FindBy(xpath = "//mat-radio-button[contains(.,'Male')]")
    private WebElement radioButtonMale;

    @FindBy(xpath = "//mat-card-actions/button[contains(.,'Login')]")
    private WebElement loginButton;

    public void clickOnRegisterButton(){
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        actions.clickAndHold(registerButton).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.release(registerButton).perform();
    }

    public void verifyThatRegistrationPageDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(registrationTitle));
        assertThat(registrationTitle.getText())
                .as("Wrong title on registration page has been displayed!")
                .contains("User Registration")
                .contains("Already Registered? ");
    }

    public void verifyThatRegistrationPageIsNotDisplayed(){
        wait.until(ExpectedConditions.invisibilityOf(registrationTitle));
    }

    public void clickOnAllRequiredElements(){
        firstNameInput.click();
        lastNameInput.click();
        userNameInput.click();
        passwordInput.click();
        confirmPasswordInput.click();
        clickOnRegisterButton();
    }

    public void fillAllRequiredFields(String firstName, String lastName, String username, String password, String confirmPassword){
        fillInput(firstName,firstNameInput);
        fillInput(lastName,lastNameInput);
        fillInput(username,userNameInput);
        fillInput(password, passwordInput);
        fillInput(confirmPassword, confirmPasswordInput);
    }

    public void verifyThatErrorDisplayed(String element) {
        switch(element){
            case "usernameError":
                wait.until(ExpectedConditions.visibilityOf(userNameError));
                break;
            case "passwordError":
                wait.until(ExpectedConditions.visibilityOf(passwordError));
                break;
            case "lastNameError":
                wait.until(ExpectedConditions.visibilityOf(lastNameError));
                break;
            case "firstNameError":
                wait.until(ExpectedConditions.visibilityOf(firstNameError));
                break;
            case "usernameAndPasswordErrors":
                wait.until(ExpectedConditions.visibilityOf(userNameError));
                wait.until(ExpectedConditions.visibilityOf(passwordError));
                break;
            case "confirmPasswordError":
                wait.until(ExpectedConditions.visibilityOf(confirmpasswordError));
                break;
            default: break;
        }
    }

    public void verifyMessageError(String element, String expectedMessage) {
        switch(element){
            case "usernameError":
                assertThatMessageExpected(userNameError.getText(), expectedMessage, userNameError);
                break;
            case "passwordError":
                assertThatMessageExpected(passwordError.getText(), expectedMessage, passwordError);
                break;
            case "lastNameError":
                assertThatMessageExpected(lastNameError.getText(), expectedMessage, lastNameError);
                break;
            case "firstNameError":
                assertThatMessageExpected(firstNameError.getText(), expectedMessage, firstNameError);
                break;
            case "confirmPasswordError":
                assertThatMessageExpected(confirmpasswordError.getText(), expectedMessage, confirmpasswordError);
                break;
            default: break;
        }
    }

    public void verifyThatErrorIsNotDisplayed(String element) {
        switch(element){
            case "usernameWithoutError":
                wait.until(ExpectedConditions.invisibilityOf(userNameError));
                break;
            case "lastNameWithoutError":
                wait.until(ExpectedConditions.invisibilityOf(lastNameError));
                break;
            case "firstNameWithoutError":
                wait.until(ExpectedConditions.invisibilityOf(firstNameError));
                break;
            case "passwordWithoutError":
                wait.until(ExpectedConditions.invisibilityOf(passwordError));
                break;
            case "usernameAndPasswordWithoutError":
                wait.until(ExpectedConditions.invisibilityOf(userNameError));
                wait.until(ExpectedConditions.invisibilityOf(passwordError));
                break;
            default: break;
        }
    }

    public void selectRadioButtonMale(){
        wait.until(ExpectedConditions.visibilityOf(radioButtonMale));
        radioButtonMale.click();
    }

    public void verifyRadioButtonMale(){
        wait.until(ExpectedConditions.visibilityOf(radioButtonMale));
        assertThatMessageExpected(radioButtonMale.getText(), "Male", radioButtonMale);
    }

    public void selectRadioButtonFemale(){
        wait.until(ExpectedConditions.visibilityOf(radioButtonFemale));
        radioButtonFemale.click();
    }

    public void verifyRadioButtonFemale(){
        wait.until(ExpectedConditions.visibilityOf(radioButtonFemale));
        assertThatMessageExpected(radioButtonFemale.getText(), "Female", radioButtonFemale);
    }
}
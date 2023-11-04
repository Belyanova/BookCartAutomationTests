package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = "//button[contains(.,'Register')]")
    private WebElement registerButton;

    @FindBy(className = "docs-example-viewer-title-spacer")
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

    @FindBy(xpath = "//mat-error[contains(.,'User Name is required')]")
    private WebElement userNameError;

    @FindBy(xpath = "//mat-error[contains(.,'Password is required')]")
    private WebElement passwordError;

    public void clickOnRegisterButton(){
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        registerButton.click();
    }

    public void verifyThatRegistrationPageDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(registrationTitle));
        assertThat(registrationTitle.getText())
                .as("Wrong title on registration page has been displayed!")
                .contains("User Registration")
                .contains("Already Registered? ");
    }

    public void clickOnAllRequiredElements(){
        firstNameInput.click();
        lastNameInput.click();
        userNameInput.click();
        passwordInput.click();
        confirmPasswordInput.click();
        clickOnRegisterButton();
    }

    public void verifyRequiredFieldsErrors(){
        wait.until(ExpectedConditions.visibilityOf(userNameError));
        wait.until(ExpectedConditions.visibilityOf(lastNameError));
        wait.until(ExpectedConditions.visibilityOf(firstNameError));
        wait.until(ExpectedConditions.visibilityOfAllElements(passwordError));
    }

    public void fillAllRequiredFields(String firstName, String lastName, String username, String password){
        fillInput(firstName,firstNameInput);
        fillInput(lastName,lastNameInput);
        fillInput(username,userNameInput);
        fillInput(password, passwordInput);
        fillInput(password, confirmPasswordInput);
    }
}
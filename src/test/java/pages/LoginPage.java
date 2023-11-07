package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends BasePage{
    @FindBy(className = "docs-example-viewer-title-spacer")
    private WebElement loginTitle;

    @FindBy(xpath = "//div/input[@data-placeholder='Username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//div/input[@data-placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//mat-card-actions/button[contains(.,'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//mat-error[contains(.,'Username is required')]")
    private WebElement usernameError;

    @FindBy(xpath = "//mat-error[contains(.,'Password is required')]")
    private WebElement passwordError;

    @FindBy(xpath = "//mat-error[contains(.,'Username or Password is incorrect.')]")
    private WebElement incorrectUsernameOrPasswordError;

    @FindBy(xpath = "//button[contains(.,'Register')]")
    private WebElement registerButton;

    public void assertThatLoginTitleExpected(){
        wait.until(ExpectedConditions.visibilityOf(loginTitle));
        assertThat(loginTitle.getText())
                .as("Wrong title on login page has been displayed!")
                .contains("Login")
                .contains("New User?")
                .contains("Register");
    }

    public void fillUsernameInput(String username){
        fillInput(username,usernameInput);
    }

    public void fillPasswordInput(String password){
        fillInput(password,passwordInput);
    }

    public void clickOnLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    public void verifyLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        assertThatMessageExpected(loginButton.getText(), "Login", loginButton);
    }

    public void verifyThatUsernameAndPasswordErrorDisplayed(){
        usernameInput.click();
        passwordInput.click();
        wait.until(ExpectedConditions.visibilityOf(usernameError));
        usernameInput.click();
        wait.until(ExpectedConditions.visibilityOf(passwordError));
    }

    public void verifyThatUsernameAndPasswordError(){
        wait.until(ExpectedConditions.visibilityOf(usernameError));
        assertThatMessageExpected(usernameError.getText(), "Username is required", usernameError);
        wait.until(ExpectedConditions.visibilityOf(passwordError));
        assertThatMessageExpected(passwordError.getText(), "Password is required", passwordError);
    }

    public void verifyThatIncorrectUsernameOrPasswordErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(incorrectUsernameOrPasswordError));
        assertThatMessageExpected(incorrectUsernameOrPasswordError.getText(),"Username or Password is incorrect.",incorrectUsernameOrPasswordError);
    }

    public void verifyThatIncorrectUsernameOrPasswordError() {
        assertThatMessageExpected(incorrectUsernameOrPasswordError.getText(),"Username or Password is incorrect.",incorrectUsernameOrPasswordError);
    }

    public void verifyThatIncorrectUsernameOrPasswordErrorIsNotDisplayed() {
        wait.until(ExpectedConditions.invisibilityOf(incorrectUsernameOrPasswordError));
    }

    public void clickOnRegisterButton(){
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        registerButton.click();
    }

    public void verifyRegisterButton(){
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        assertThatMessageExpected(registerButton.getText(), "Register", registerButton);
    }
}
package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends BasePage{
    @FindBy(className = "docs-example-viewer-title-spacer")
    private WebElement loginTitle;

    @FindBy(id = "mat-input-0")
    private WebElement usernameInput;

    @FindBy(id = "mat-input-1")
    private WebElement passwordInput;

    @FindBy(xpath = "//mat-card-actions/button/span")
    private WebElement loginButton;

    @FindBy(id = "mat-error-0")
    private WebElement usernameError;

    @FindBy(id = "mat-error-1")
    private WebElement passwordError;

    public void assertThatLoginTitleExpected(){
        wait.until(ExpectedConditions.visibilityOf(loginTitle));
        assertThat(loginTitle.getText())
                .as(" Wrong text has been displayed!")
                .contains("Login");
    }

    public void fillUsernameInput(){
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.click();
        usernameInput.sendKeys("testname-iri");
    }

    public void fillPasswordInput(){
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.click();
        passwordInput.sendKeys("123Test123!");
    }

    public void clickOnLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    public void assertThatUsernameErrorExpected(){
        usernameInput.click();
        passwordInput.click();
        wait.until(ExpectedConditions.visibilityOf(usernameError));
        assertThat(usernameError.getText())
                .as(" Wrong text has been displayed!")
                .contains("Username is required");
    }

    public void assertThatPasswordErrorExpected(){
        passwordInput.click();
        usernameInput.click();
        wait.until(ExpectedConditions.visibilityOf(passwordError));
        assertThat(passwordError.getText())
                .as(" Wrong text has been displayed!")
                .contains("Password is required");
    }
}

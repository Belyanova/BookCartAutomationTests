package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralPage extends BasePage{
    @FindBy(xpath = "//button[1]/span")
    private WebElement  bookCartButton;

    @FindBy(xpath = "//button[2]/span")
    private WebElement loginButton;

    @FindBy(xpath = "//span[contains(.,'account_circle')]")
    private WebElement usernameButton;

    @FindBy(xpath = "//button[contains(.,'Logout')]")
    private WebElement logoutButton;

    @FindBy(className = "cdk-overlay-container")
    private WebElement dropdown;

    public void assertThatBookCartButtonExpected(){
        wait.until(ExpectedConditions.visibilityOf(bookCartButton));
        assertThat(bookCartButton.getText())
                .as("Wrong Book Cart button has been displayed!")
                .contains("Book Cart");
    }

    public void assertThatLoginButtonExpected(){
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        assertThat(loginButton.getText())
                .as("Wrong Login button has been displayed!")
                .contains("Login");
    }

    public void clickOnLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    public void verifyThatUsernameExpected(String username){
        wait.until(ExpectedConditions.visibilityOf(usernameButton));
        assertThat(usernameButton.getText())
                .as("Wrong username has been displayed!")
                .contains(username);
    }

    public void clickOnLogoutButton(){
        wait.until(ExpectedConditions.visibilityOf(usernameButton));
        usernameButton.click();
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }
}

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

    @FindBy(className = "")
    private WebElement username;

    public void assertThatBookCartButtonExpected(){
        wait.until(ExpectedConditions.visibilityOf(bookCartButton));
        assertThat(bookCartButton.getText())
                .as(" Wrong text has been displayed!")
                .contains("Book Cart");
    }

    public void assertThatLoginButtonExpected(){
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        assertThat(loginButton.getText())
                .as(" Wrong text has been displayed!")
                .contains("Login");
    }

    public void clickOnLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }

    public void verifyUsername(){
        wait.until(ExpectedConditions.visibilityOf(username));
        assertThat(username.getText())
                .as(" Wrong text has been displayed!")
                .contains("testname-iri");
    }
}

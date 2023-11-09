package pages;

import java.util.Random;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralPage extends BasePage{
    @FindBy(xpath = "//button[contains(.,'Book Cart')]")
    private WebElement  bookCartButton;

    @FindBy(xpath = "//button[2]/span")
    private WebElement loginButton;

    @FindBy(xpath = "//span[contains(.,'account_circle')]")
    private WebElement usernameButton;

    @FindBy(xpath = "//button[contains(.,'Logout')]")
    private WebElement logoutButton;

    @FindBy(className = "cdk-overlay-container")
    private WebElement dropdown;

    @FindBy(xpath = "//div/app-book-card/mat-card/mat-card-content/a/img")
    private List<WebElement> booksElement;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

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
        actions.clickAndHold(usernameButton).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.release(usernameButton).perform();
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        actions.clickAndHold(logoutButton).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.release(logoutButton).perform();
    }

    public List<WebElement> findAllBooksElements() {
        return wait.until(ExpectedConditions.visibilityOfAllElements(booksElement));
    }

    public WebElement findBookElement() {
        if (booksElement.size() != 1) {
            return null;
        } else {
            return wait.until(ExpectedConditions.visibilityOf(booksElement.get(0)));
        }
    }

    public void clickOnBookElement(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public WebElement getRandomElement(List<WebElement> webElements) {
        if (webElements.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(webElements.size());
        return webElements.get(randomIndex);
    }

    public boolean checkSearchResults(String title){
        WebElement webElement = findBookElement();
        if (webElement.getText()!= title){
            return false;
        } else {
            return true;
        }
    }
}
package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pages.GeneralPage;
import java.util.List;

public class GeneralSteps {
    private final GeneralPage generalPage = new GeneralPage();

    @Step("Verify General Page No Login Account")
    public GeneralSteps verifyGeneralPageNoLoginAccount(){
        generalPage.assertThatBookCartButtonExpected();
        generalPage.assertThatLoginButtonExpected();
        return this;
    }

    @Step("Go To Login Page")
    public LoginSteps goToLoginPage(){
        generalPage.assertThatLoginButtonExpected();
        generalPage.clickOnLoginButton();
        return new LoginSteps();
    }

    @Step("Verify That Username Expected")
    public GeneralSteps verifyThatUsernameExpected(String username){
        generalPage.verifyThatUsernameExpected(username);
        return this;
    }

    @Step("Logout Of Account")
    public void logoutOfAccount(){
        generalPage.clickOnLogoutButton();
        generalPage.assertThatLoginButtonExpected();
    }

    @Step("Сlick On Random Book Element")
    public BookSteps clickOnRandomBookElement() {
        WebElement element = selectRandomBookElement();
        generalPage.clickOnBookElement(element);
        return new BookSteps();
    }

    @Step("Select Random Book Element")
    public WebElement selectRandomBookElement(){
        List<WebElement> elements = generalPage.findAllBooksElements();
        WebElement element = generalPage.getRandomElement(elements);
        return element;
    }

    @Step("Check Search Results")
    public GeneralSteps checkSearchResults(){
        generalPage.checkSearchResults();
        return this;
    }
}
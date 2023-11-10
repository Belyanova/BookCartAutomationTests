package ui_tests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class ShoppingCartPage extends BasePage{
    @FindBy(xpath = "//table/tbody/tr/mat-card-content/td[2]/a")
    private List<WebElement> titleBookOnShoppingCart;

    @FindBy(xpath = "//div/mat-card/mat-card-title")
    private WebElement titleShoppingCartPage;

    @FindBy(xpath = "//mat-card-content/button")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//app-shoppingcart/div/div/div/div/button")
    private WebElement clearCartButton;

    @FindBy(xpath = "//table/tbody/tr/mat-card-content/td[4]/div/div[2]")
    private List<WebElement> countBookOnShoppingCart;

    @FindBy(xpath = "//table/tbody//button[contains(.,'delete')]")
    private List<WebElement> deleteButton;

    @FindBy(xpath = "//div/simple-snack-bar")
    private WebElement informMessage;

    @FindBy(xpath = "//table//button//mat-icon[contains(.,'remove_circle')]")
    private List<WebElement> removeCircleButton;

    @FindBy(xpath = "//table//button//mat-icon[contains(.,'add_circle')]")
    private List<WebElement> addCircleButton;

    public void verifyTitleBookOnShoppingCart(String expectedTitle, int i){
        wait.until(ExpectedConditions.visibilityOfAllElements(titleBookOnShoppingCart));
        String title = titleBookOnShoppingCart.get(i).getText();
        assertThatMessageExpected(title, expectedTitle, titleBookOnShoppingCart.get(i));
    }

    public void verifyThatTitleIsNotDisplayed(){
        if(titleBookOnShoppingCart.size()!=1) {
            WebElement lastWebElement = titleBookOnShoppingCart.get(1);
            wait.until(ExpectedConditions.invisibilityOf(lastWebElement));
        }
    }

    public void clickOnContinueShoppingButton(){
        verifyContinueShoppingButton();
        clickOnButton(continueShoppingButton);
    }

    public void clickOnDeleteBookButton(int i){
        clickOnButton(deleteButton.get(i));
    }

    public void verifyContinueShoppingButton(){
        String button = continueShoppingButton.getText();
        assertThatMessageExpected(button, "Continue shopping", continueShoppingButton);
    }

    public void verifyCountBookOnShoppingCart(String expectedCount, int i){
        wait.until(ExpectedConditions.invisibilityOf(informMessage));
        String count = countBookOnShoppingCart.get(i).getText();
        assertThatMessageExpected(count, expectedCount, countBookOnShoppingCart.get(i));
    }

    public void clickOnRemoveCircleButton(int i){
        clickOnButton(removeCircleButton.get(i));
        verifyInformMessageItemRemoved();
    }

    public void clickOnAddCircleButton(int i){
        clickOnButton(addCircleButton.get(i));
        verifyInformMessageItemAdded();
    }

    public void clickOnClearCartButton(){
        verifyClearCartButton();
        clickOnButton(clearCartButton);
    }

    public void verifyClearCartButton(){
        String button = clearCartButton.getText();
        assertThatMessageExpected(button, "Clear cart", clearCartButton);
    }

    public void verifyShoppingCart(){
        if(titleShoppingCartPage.isDisplayed()){
            clickOnContinueShoppingButton();
        } else {
            clickOnClearCartButton();
        }
    }

    public void verifyInformMessageProductRemoved(){
        wait.until(ExpectedConditions.visibilityOf(informMessage));
        String informMessageText = informMessage.getText();
        assertThatMessageExpected(informMessageText, "Product removed from cart", informMessage);
    }

    public void verifyInformMessageItemRemoved(){
        wait.until(ExpectedConditions.visibilityOf(informMessage));
        String informMessageText = informMessage.getText();
        assertThatMessageExpected(informMessageText, "One item removed from cart", informMessage);
    }

    public void verifyInformMessageItemAdded(){
        wait.until(ExpectedConditions.visibilityOf(informMessage));
        String informMessageText = informMessage.getText();
        assertThatMessageExpected(informMessageText, "One item added to cart", informMessage);
    }
}
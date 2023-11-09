package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class BookPage extends BasePage{
    @FindBy(xpath = "//div/table/tr/td[2]")
    private List<WebElement> bookDetailsTitle;

    @FindBy(xpath = "//div/table/tr[2]/td[2]")
    private List<WebElement> bookDetailsAuthor;

    @FindBy(xpath = "//button[contains(.,'Book Cart')]")
    private WebElement bookCartButton;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//div/mat-option/span")
    private WebElement dropDownListValue;

    @FindBy(xpath = "//div/app-addtocart/button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div/div/h2")
    private List<WebElement> bookPageTitles;

    @FindBy(xpath = "//div/simple-snack-bar")
    private WebElement informMessage;

    public void verifyBookPageTitles(){
        wait.until(ExpectedConditions.visibilityOfAllElements(bookPageTitles));
        String bookDetailsTitle1 = bookPageTitles.get(0).getText();
        assertThatMessageExpected(bookDetailsTitle1,"Book Details",bookPageTitles.get(0));
        String bookDetailsTitle2 = bookPageTitles.get(1).getText();
        assertThatMessageExpected(bookDetailsTitle2,"Similar Books",bookPageTitles.get(1));
    }

    public String findElementTitle() {
        return bookDetailsTitle.get(0).getText();
    }

    public String findElementAuthor() {
        return bookDetailsAuthor.get(0).getText();
    }

    public void verifyAuthor(String author) {
        String findAuthor = findElementAuthor();
        assertThatMessageExpected(findAuthor, author,bookDetailsAuthor.get(0));
    }

    public void clickOnSearchField(){
        clickOnButton(searchField);
    }

    public void fillSearchField(String text){
        fillInput(text,searchField);
    }

    public void clickOnDropDownListValue(){
        clickOnButton(dropDownListValue);
    }

    public void clickOnAddToCartButton(){
        clickOnButton(addToCartButton);
        verifyInformMessage();
    }

    public void verifyInformMessage(){
        wait.until(ExpectedConditions.visibilityOf(informMessage));
        String informMessageText = informMessage.getText();
        assertThatMessageExpected(informMessageText, "One Item added to cart", informMessage);
    }
}
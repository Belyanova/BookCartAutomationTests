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

    public String findElementTitle() {
        return bookDetailsTitle.get(0).getText();
    }

    public String findElementAuthor() {
        return bookDetailsAuthor.get(0).getText();
    }

    public void verifyAuthor(String author) {
        String findAuthor = findElementAuthor();
        assertThatMessageExpected(findAuthor, author,bookDetailsAuthor.get(0));
        System.out.println(findAuthor);
    }

    public void clickOnSearchField(){
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.click();
    }

    public void fillSearchField(String text){
        fillInput(text,searchField);
    }

    public void clickOnDropDownListValue(){
        wait.until(ExpectedConditions.visibilityOf(dropDownListValue));
        dropDownListValue.click();
    }
}
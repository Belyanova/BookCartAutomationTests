package ui_tests.steps;

import io.qameta.allure.Step;
import ui_tests.pages.BookPage;

public class BookSteps {
    private final BookPage bookPage = new BookPage();

    @Step("Verify That Book Page Displayed")
    public BookSteps verifyThatBookPageDisplayed(){
        bookPage.verifyBookPageTitles();
        return this;
    }

    @Step("Search By Title")
    public BookSteps searchByTitle(String title){
        bookPage.clickOnSearchField();
        bookPage.fillSearchField(title);
        return this;
    }

    @Step("Search By Author")
    public BookSteps searchByAuthor(String author){
        bookPage.clickOnSearchField();
        bookPage.fillSearchField(author);
        return this;
    }

    @Step("Verify Author")
    public void verifyAuthor(String author){
        bookPage.verifyAuthor(author);
    }

    @Step("Find Element Title")
    public String findElementTitle(){
        return bookPage.findElementTitle();
    }

    @Step("Find Element Author")
    public String findElementAuthor(){
        return bookPage.findElementAuthor();
    }

    @Step("Click On Drop-Down List Value")
    public GeneralSteps clickOnDropDownListValue (){
        bookPage.clickOnDropDownListValue();
        return new GeneralSteps();
    }

    @Step("Click On Shopping Cart Button")
    public BookSteps clickOnAddToCartButton(){
        bookPage.clickOnAddToCartButton();
        return this;
    }
}
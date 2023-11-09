package steps;

import io.qameta.allure.Step;
import pages.BookPage;

public class BookSteps {
    private final BookPage bookPage = new BookPage();

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
}
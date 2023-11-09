package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("Search Tests")
public class SearchTests extends BaseTests {
    @Test(description = "Search By Title Book Results Exist Search Test")
    public void searchByTitleBookResultsExistSearchTest() {
        String titleBook = generalSteps.verifyGeneralPageNoLoginAccount()
                .clickOnRandomBookElement()
                .findElementTitle();

        bookSteps.searchByTitle(titleBook)
                .clickOnDropDownListValue()
                .checkSearchResults(titleBook);
    }

    @Test(description = "Search By Author Book Results Exist Search Test")
    public void searchByAuthorBookResultsExistSearchTest() {
        String authorBook = generalSteps.verifyGeneralPageNoLoginAccount()
                .clickOnRandomBookElement()
                .findElementAuthor();

        bookSteps.searchByAuthor(authorBook)
                .clickOnDropDownListValue()
                .clickOnRandomBookElement()
                .verifyAuthor(authorBook);
    }
}
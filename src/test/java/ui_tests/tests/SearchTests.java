package ui_tests.tests;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("Search Tests")
public class SearchTests extends BaseTests {
    @Test(description = "Search By Title Book Results Exist Search Test", alwaysRun = true)
    public void searchByTitleBookResultsExistSearchTest() {
        String titleBook = generalSteps.verifyGeneralPageNoLoginAccount()
                .clickOnRandomBookElement()
                .verifyThatBookPageDisplayed()
                .findElementTitle();

        bookSteps.searchByTitle(titleBook)
                .clickOnDropDownListValue()
                .checkSearchResults(titleBook);
    }

    @Test(description = "Search By Author Book Results Exist Search Test", alwaysRun = true)
    public void searchByAuthorBookResultsExistSearchTest() {
        String authorBook = generalSteps.verifyGeneralPageNoLoginAccount()
                .clickOnRandomBookElement()
                .verifyThatBookPageDisplayed()
                .findElementAuthor();

        bookSteps.searchByAuthor(authorBook)
                .clickOnDropDownListValue()
                .clickOnRandomBookElement()
                .verifyThatBookPageDisplayed()
                .verifyAuthor(authorBook);
    }
}
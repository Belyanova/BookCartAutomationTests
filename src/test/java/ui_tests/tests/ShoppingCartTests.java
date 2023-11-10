package ui_tests.tests;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("Shopping Cart Tests")
public class ShoppingCartTests  extends BaseTests {
    @Test(description = "Add One Book On Shopping Cart Test", alwaysRun = true)
    public void addOneBookAndClearCartOnShoppingCartTest(){
        String titleBook = generalSteps.clickOnShoppingCartButton()
                .verifyShoppingCart()
                .verifyGeneralPageNoLoginAccount()
                .clickOnRandomBookElement()
                .verifyThatBookPageDisplayed()
                .findElementTitle();
        bookSteps.clickOnAddToCartButton();
        generalSteps.clickOnShoppingCartButton()
                .verifyTitleBookOnShoppingCart(titleBook, 0)
                .verifyCountBookOnShoppingCart("1", 0)
                .clickOnClearCartButton();
    }

    @Test(description = "Add Two Books And Delete One Book On Shopping Cart Test", alwaysRun = true)
    public void addTwoBooksAndDeleteOneBookOnShoppingCartTest(){
        String titleBook1 = generalSteps.clickOnShoppingCartButton()
                .verifyShoppingCart()
                .verifyGeneralPageNoLoginAccount()
                .clickOnRandomBookElement()
                .verifyThatBookPageDisplayed()
                .findElementTitle();
        bookSteps.clickOnAddToCartButton();
        String titleBook2 = generalSteps.clickOnBookCartButton()
                .clickOnRandomBookElement()
                .verifyThatBookPageDisplayed()
                .findElementTitle();
        bookSteps.clickOnAddToCartButton();
        generalSteps.clickOnShoppingCartButton()
                .verifyCountBookOnShoppingCart("1", 0)
                .verifyCountBookOnShoppingCart("1", 1)
                .deleteFirstBookButton(titleBook1, titleBook2);
    }

    @Test(description = "Add Two Books And Change Count Books On Shopping Cart Test", alwaysRun = true)
    public void addTwoBooksAndChangeCountBooksOnShoppingCartTest() {
        generalSteps.clickOnShoppingCartButton()
                .verifyShoppingCart()
                .verifyGeneralPageNoLoginAccount()
                .clickOnRandomBookElement()
                .verifyThatBookPageDisplayed()
                .findElementTitle();
        bookSteps.clickOnAddToCartButton();
        generalSteps.clickOnBookCartButton()
                .clickOnRandomBookElement()
                .verifyThatBookPageDisplayed()
                .findElementTitle();
        bookSteps.clickOnAddToCartButton();
        generalSteps.clickOnShoppingCartButton()
                .verifyCountBookOnShoppingCart("1", 0)
                .verifyCountBookOnShoppingCart("1", 1)
                .clickOnAddCircleButton(0)
                .verifyCountBookOnShoppingCart("2", 0)
                .clickOnRemoveCircleButton(0)
                .verifyCountBookOnShoppingCart("1", 0)
                .clickOnClearCartButton();
    }
}

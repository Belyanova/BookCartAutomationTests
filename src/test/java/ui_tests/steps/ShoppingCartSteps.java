package ui_tests.steps;

import io.qameta.allure.Step;
import ui_tests.pages.ShoppingCartPage;

public class ShoppingCartSteps {
    private final ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    @Step("Verify Title Book On Shopping Cart")
    public ShoppingCartSteps verifyTitleBookOnShoppingCart(String title, int i){
        shoppingCartPage.verifyTitleBookOnShoppingCart(title, i);
        return this;
    }

    @Step("Verify Count Book On Shopping Cart")
    public ShoppingCartSteps verifyCountBookOnShoppingCart(String count, int i){
        shoppingCartPage.verifyCountBookOnShoppingCart(count, i);
        return this;
    }

    @Step("Verify Shopping Cart")
    public GeneralSteps verifyShoppingCart(){
        shoppingCartPage.verifyShoppingCart();
        return new GeneralSteps();
    }

    @Step("Click On Clear Cart Button")
    public ShoppingCartSteps clickOnClearCartButton(){
        shoppingCartPage.clickOnClearCartButton();
        return this;
    }

    @Step("Delete First Book Button")
    public ShoppingCartSteps deleteFirstBookButton(String title1, String title2){
        if(title1.compareTo(title2)<0){
            shoppingCartPage.clickOnDeleteBookButton(0);
            shoppingCartPage.verifyInformMessageProductRemoved();
            shoppingCartPage.verifyThatTitleIsNotDisplayed();
            shoppingCartPage.verifyTitleBookOnShoppingCart(title2, 0);
        } else {
            shoppingCartPage.clickOnDeleteBookButton(0);
            shoppingCartPage.verifyInformMessageProductRemoved();
            shoppingCartPage.verifyThatTitleIsNotDisplayed();
            shoppingCartPage.verifyTitleBookOnShoppingCart(title1, 0);
        }
        return this;
    }

    @Step("Click On Remove Circle Button")
    public ShoppingCartSteps clickOnRemoveCircleButton(int i){
        shoppingCartPage.clickOnRemoveCircleButton(i);
        return this;
    }

    @Step("Click On Add Circle Button")
    public ShoppingCartSteps clickOnAddCircleButton(int i){
        shoppingCartPage.clickOnAddCircleButton(i);
        return this;
    }
}
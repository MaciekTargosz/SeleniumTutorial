package com.selenium.test.pages;

import com.selenium.test.utils.ActionBot;
import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by SG0943274 on 2017-03-23.
 */
public class ProductListPage extends BasePage {

    public ProductListPage() {
        super(false);
    }

    @Override
    protected void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return getDriver().findElement(By.className("product-thumb")).isDisplayed();
    }

    public ProductListPage addItemToCart(String itemName) {
        new ActionBot(getDriver()).click(By.xpath("//div[./div/h4/a[contains(text(),'" + itemName + "')]]/div[contains(@class,'button-group')]/button[contains(@onclick,'cart')]"));
        return this;
    }

    public ProductListPage showCartItemsList() {
        new ActionBot(getDriver()).waitUntilElementClickableAndClickOnIt(By.id("cart-total"), 5);
        return this;
    }

    public OrderDetailsPage goToOrderDetails() {
        new ActionBot(getDriver()).waitUntilElementClickableAndClickOnIt(By.xpath("//div[@id='cart']/ul/li[2]/div/p/a[2]/strong"), 5);
        return new OrderDetailsPage(false);
    }
}

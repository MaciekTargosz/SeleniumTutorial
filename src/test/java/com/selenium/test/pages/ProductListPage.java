package com.selenium.test.pages;

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

    public void addItemToCart() {
        getDriver().findElement(By.xpath("(//button[@type='button'])[15]")).click();
    }

    public ProductListPage addItemToCart(String itemName) {                                     // will change when ActionBot introduced
        getDriver().findElement(By.xpath("//div[./div/h4/a[contains(text(),'" + itemName + "')]]/div[contains(@class,'button-group')]/button[contains(@onclick,'cart')]")).click();
        return this;
    }

    public ProductListPage showCartItemsList() {                                                // will change when ActionBot introduced
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cart-total")));
        getDriver().findElement(By.id("cart-total")).click();
        return this;
    }

    public OrderDetailsPage goToOrderDetails() {                                                // will change when ActionBot introduced
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cart']/ul/li[2]/div/p/a[2]/strong")));
        getDriver().findElement(By.xpath("//div[@id='cart']/ul/li[2]/div/p/a[2]/strong")).click();
        return new OrderDetailsPage(false);
    }
}

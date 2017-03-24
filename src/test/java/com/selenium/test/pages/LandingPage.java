package com.selenium.test.pages;

import com.selenium.test.configuration.TestsConfig;
import com.selenium.test.configuration.properties.Property;
import com.selenium.test.configuration.properties.PropertyFile;
import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.By;

public class LandingPage extends BasePage{

    public LandingPage(){
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(TestsConfig.getBaseURL());
    }

    @Override
    public boolean isPageOpened() {
        return getDriver().findElement(By.id("cart")).isDisplayed();
    }

    public ProductListPage goToProductList(String category, String subcategory) {
        getDriver().findElement(By.linkText(category)).click();
        getDriver().findElement(By.partialLinkText(subcategory)).click();
        return new ProductListPage();
    }

    public LandingPage changeLanguage(String language){
        getDriver().findElement(By.xpath("//form[@id='form-language']/div/button")).click();
        getDriver().findElement(By.xpath("//button[contains(text(),'" + language + "')]")).click();
        return this;
    }
}

package com.selenium.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.selenium.test.webtestsbase.WebDriverFactory.getDriver;

/**
 * Created by SG0943274 on 2017-03-25.
 */
public class ActionBot {

    private final WebDriver driver;

    public static final String SKIP_VALUE = "SKIP_VALUE";

    public ActionBot(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void click(WebElement element) {
        element.click();
    }

    public ActionBot click(String linkText) {               //it is UGLY, potential NPE
        WebElement element = getElementIfAvailable(By.linkText(linkText));
        if(element == null){
            element = getElementIfAvailable(By.partialLinkText(linkText));
        }
        element.click();
        return this;
    }

    public void submit(By locator) {
        driver.findElement(locator).submit();
    }

    /**
     * Type something into an input field. WebDriver doesn't normally clear these
     * before typing, so this method does that first. It also sends a return key
     * to move the focus out of the element.
     */
    public void type(By locator, String text) {
        if(!text.equals(SKIP_VALUE)) {
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text + "\n");
        }
    }

    public void type(WebElement element, String text) {
        if(!text.equals(SKIP_VALUE)) {
            element.clear();
            element.sendKeys(text + "\n");
        }
    }

    public void addText(By locator, String text) {
        if(!text.equals(SKIP_VALUE)) {
            WebElement element = driver.findElement(locator);
            element.sendKeys(text + "\n");
        }
    }

    public void findButtonByTextAndClickOnIt(String text){
        click(getDriver().findElement(By.xpath("//button[contains(text(),'" + text + "')]")));
    }

    public void waitUntilElementClickableAndClickOnIt(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        click(getDriver().findElement(locator));
    }

    private WebElement getElementIfAvailable(By locator){
        WebElement element = null;
        try{
            element = getDriver().findElement(locator);
        }
        catch(NoSuchElementException nseException){
            System.out.println("WARN - element not found by locator: " + locator);
        }
        return element;
    }
}

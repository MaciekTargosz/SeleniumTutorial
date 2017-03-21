package com.selenium.test.testng.tests;


import java.util.concurrent.TimeUnit;

import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class NewOrderSeleniumIDE {
    private WebDriver driver;
    WebDriverWait wait;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private static final String BASE_URL = "http://localhost";
    private static final String COUNTRY = "Poland";
    private static final String REGION = "Malopolskie";
    private static final String COMMENT = "Komentarz do testowego zamówienia";
    private static final String FIRST_NAME = "Tester";
    private static final String LAST_NAME = "Testerski";
    private static final String EMAIL = "mactar.training@gmail.com";
    private static final String PHONE = "123654789";
    private static final String ADDRESS = "Testowa 7";
    private static final String CITY = "Testowo";
    private static final String POST_CODE = "39-100";

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        WebDriverFactory.startBrowser(true);
        driver = WebDriverFactory.getDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void shouldCreateNewOrderWithoutRegistration() throws Exception {
        openLandingPage();
        changeLanguage();
        navigateToMonitorsCategory();
        addItemToCart();
        showCartItemsList();
        goToOrderDetails();
        selectGuestCheckoutOption();
        clickContinueCheckoutOptions();
        typeFirstName(FIRST_NAME);
        typeLastName(LAST_NAME);
        typeEmailAddress(EMAIL);
        typePhoneNumber(PHONE);
        typeAddressPart1(ADDRESS);
        typeCity(CITY);
        typePostCode(POST_CODE);
        selectCountry(COUNTRY);
        selectRegionOrState(REGION);
        clickContinueBillingDetails();
        typeDeliveryMethodComment(COMMENT);
        clickContinueDeliveryMethod();
        agreeToTermsAndConditions();
        clickContinuePaymentMethod();
        clickConfirmOrder();
        clickContinue();
    }

    private void clickContinue() {
        driver.findElement(By.linkText("Kontynuuj")).click();
    }

    private void clickConfirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm")));
        driver.findElement(By.id("button-confirm")).click();
    }

    private void clickContinuePaymentMethod() {
        driver.findElement(By.id("button-payment-method")).click();
    }

    private void agreeToTermsAndConditions() {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("agree")));
        driver.findElement(By.name("agree")).click();
    }

    private void clickContinueDeliveryMethod() {
        driver.findElement(By.id("button-shipping-method")).click();
    }

    private void typeDeliveryMethodComment(String comment) {
        driver.findElement(By.name("comment")).clear();
        driver.findElement(By.name("comment")).sendKeys(comment);
    }

    private void clickContinueBillingDetails() {
        driver.findElement(By.id("button-guest")).click();
    }

    private void selectRegionOrState(String region) {
        new Select(driver.findElement(By.id("input-payment-zone"))).selectByVisibleText(region);
    }

    private void selectCountry(String countryName) {
        new Select(driver.findElement(By.id("input-payment-country"))).selectByVisibleText(countryName);
    }

    private void typePostCode(String postCode) {
        driver.findElement(By.id("input-payment-postcode")).clear();
        driver.findElement(By.id("input-payment-postcode")).sendKeys(postCode);
    }

    private void typeCity(String city) {
        driver.findElement(By.id("input-payment-city")).clear();
        driver.findElement(By.id("input-payment-city")).sendKeys(city);
    }

    private void typeAddressPart1(String address) {
        driver.findElement(By.id("input-payment-address-1")).clear();
        driver.findElement(By.id("input-payment-address-1")).sendKeys(address);
    }

    private void typePhoneNumber(String phone) {
        driver.findElement(By.id("input-payment-telephone")).clear();
        driver.findElement(By.id("input-payment-telephone")).sendKeys(phone);
    }

    private void typeEmailAddress(String email) {
        driver.findElement(By.id("input-payment-email")).clear();
        driver.findElement(By.id("input-payment-email")).sendKeys(email);
    }

    private void typeLastName(String lastName) {
        driver.findElement(By.id("input-payment-lastname")).clear();
        driver.findElement(By.id("input-payment-lastname")).sendKeys(lastName);
    }

    private void typeFirstName(String firstName) {
        driver.findElement(By.id("input-payment-firstname")).clear();
        driver.findElement(By.id("input-payment-firstname")).sendKeys(firstName);
    }

    private void clickContinueCheckoutOptions() {
        driver.findElement(By.id("button-account")).click();
    }

    private void selectGuestCheckoutOption() {
        driver.findElement(By.xpath("(//input[@name='account'])[2]")).click();
    }

    private void goToOrderDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cart']/ul/li[2]/div/p/a[2]/strong")));
        driver.findElement(By.xpath("//div[@id='cart']/ul/li[2]/div/p/a[2]/strong")).click();
    }

    private void showCartItemsList() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[8]")));
        driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
    }

    private void addItemToCart() {
        driver.findElement(By.xpath("(//button[@type='button'])[15]")).click();
    }

    private void navigateToMonitorsCategory() {
        driver.findElement(By.linkText("Akcesoria")).click();
        driver.findElement(By.linkText("Monitory (2)")).click();
    }

    private void changeLanguage(){
        driver.findElement(By.xpath("//form[@id='form-language']/div/button")).click();
        driver.findElement(By.name("pl-PL")).click();
    }

    private void openLandingPage() {
        driver.get(BASE_URL + "/opencart/");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}

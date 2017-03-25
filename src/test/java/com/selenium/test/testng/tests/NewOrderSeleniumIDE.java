package com.selenium.test.testng.tests;


import java.util.concurrent.TimeUnit;

import com.selenium.test.pages.LandingPage;
import com.selenium.test.pages.OrderDetailsPage;
import com.selenium.test.pages.ProductListPage;
import com.selenium.test.to.Address;
import com.selenium.test.to.Buyer;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class NewOrderSeleniumIDE {

    private WebDriver driver;
    WebDriverWait wait;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private static final String LANGUAGE = "Polski";
    private static final String ITEM = "Samsung SyncMaster 941BW";
    private static final String BASE_URL = "http://localhost";
    private static final String CATEGORY = /*"Akcesoria"*/"Components";
    private static final String SUBCATEGORY = /*"Monitory"*/"Monitors";
    private static final String COMMENT = "Komentarz do testowego zamówienia";
    private static final String ORDER_HASS_BEEN_PLACED_MESSAGE = "Twoje zamówienie zostało przyjęte!";

    @DataProvider(name = "buyerAndAddressData")
    public Object[][] createData1() {

        Buyer buyer = new Buyer();
        buyer.setFirstName("Tester");
        buyer.setLastName("Testerski");
        buyer.setEmail("mactar.training@gmail.com");
        buyer.setPhone("123654789");

        Address address = new Address()
                .withAddressPart1("Testowa 7")
                .withCity("Testowo")
                .withPostCode("39-100")
                .withCountry("Poland")
                .withRegion("Malopolskie");

        return new Object[][] {
                {buyer, address},
        };
    }

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        WebDriverFactory.startBrowser(true);
        driver = WebDriverFactory.getDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "buyerAndAddressData")
    public void shouldCreateNewOrderWithoutRegistration(Buyer buyer, Address address) throws Exception {
        new LandingPage()
                .changeLanguage(LANGUAGE)
                .goToProductList(CATEGORY, SUBCATEGORY)
                    .addItemToCart(ITEM)
                    .showCartItemsList()
                    .goToOrderDetails()
                        .selectGuestCheckoutOption()
                        .clickContinueCheckoutOptions()
                        .fillBuyerAndAddressData(buyer, address)
                        .clickContinueBillingDetails()
                        .typeDeliveryMethodComment(COMMENT)
                        .clickContinueDeliveryMethod()
                        .agreeToTermsAndConditions()
                        .clickContinuePaymentMethod()
                        .clickConfirmOrder();

        assertEquals(getOrderConfirmationMessageText(), ORDER_HASS_BEEN_PLACED_MESSAGE, "Confirmation message should be displayed.");
    }

    private void clickContinue() {
        driver.findElement(By.linkText("Kontynuuj")).click();
    }

    private String getOrderConfirmationMessageText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'breadcrumb')]/li/a[contains(@href, 'checkout/success')]")));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'content')]/h1"))).getText();
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

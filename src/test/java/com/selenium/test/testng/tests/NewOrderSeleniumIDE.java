package com.selenium.test.testng.tests;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewOrderSeleniumIDE {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://localhost/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testNewOrderSeleniumIDE() throws Exception {
        driver.get(baseUrl + "/opencart/");
        driver.findElement(By.xpath("//form[@id='form-language']/div/button")).click();
        driver.findElement(By.name("pl-PL")).click();
        driver.findElement(By.linkText("Monitory (2)")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[15]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
        driver.findElement(By.xpath("//div[@id='cart']/ul/li[2]/div/p/a[2]/strong")).click();
        driver.findElement(By.xpath("(//input[@name='account'])[2]")).click();
        driver.findElement(By.id("button-account")).click();
        driver.findElement(By.id("input-payment-firstname")).clear();
        driver.findElement(By.id("input-payment-firstname")).sendKeys("Maciej");
        driver.findElement(By.id("input-payment-firstname")).clear();
        driver.findElement(By.id("input-payment-firstname")).sendKeys("Tester");
        driver.findElement(By.id("input-payment-lastname")).clear();
        driver.findElement(By.id("input-payment-lastname")).sendKeys("Testerski");
        driver.findElement(By.id("input-payment-email")).clear();
        driver.findElement(By.id("input-payment-email")).sendKeys("mactar.training@gmail.com");
        driver.findElement(By.id("input-payment-telephone")).clear();
        driver.findElement(By.id("input-payment-telephone")).sendKeys("123654789");
        driver.findElement(By.id("input-payment-address-1")).clear();
        driver.findElement(By.id("input-payment-address-1")).sendKeys("Testowa 7");
        driver.findElement(By.id("input-payment-city")).clear();
        driver.findElement(By.id("input-payment-city")).sendKeys("Testowo");
        driver.findElement(By.id("input-payment-postcode")).clear();
        driver.findElement(By.id("input-payment-postcode")).sendKeys("39-100");
        new Select(driver.findElement(By.id("input-payment-country"))).selectByVisibleText("Poland");
        new Select(driver.findElement(By.id("input-payment-zone"))).selectByVisibleText("Malopolskie");
        driver.findElement(By.id("button-guest")).click();
        driver.findElement(By.name("comment")).clear();
        driver.findElement(By.name("comment")).sendKeys("Komentarz do testowego zamówienia");
        driver.findElement(By.id("button-shipping-method")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.id("button-payment-method")).click();
        driver.findElement(By.id("button-confirm")).click();
        driver.findElement(By.linkText("Kontynuuj")).click();
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

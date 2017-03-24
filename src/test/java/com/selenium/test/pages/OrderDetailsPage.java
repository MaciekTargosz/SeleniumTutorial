package com.selenium.test.pages;

import com.selenium.test.to.Address;
import com.selenium.test.to.Buyer;
import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by SG0943274 on 2017-03-23.
 */
public class OrderDetailsPage extends BasePage {

    public OrderDetailsPage(boolean openPageByUrl) {
        super(openPageByUrl);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='content']/div[@id='accordion']")));
        return getDriver().findElement(By.xpath("//div[@id='content']/div[@id='accordion']")).isDisplayed();
    }

    public OrderDetailsPage selectGuestCheckoutOption() {
        getDriver().findElement(By.xpath("(//input[@name='account'])[2]")).click();
        return this;
    }

    public OrderDetailsPage clickContinueCheckoutOptions() {
        getDriver().findElement(By.id("button-account")).click();
        return this;
    }

    public OrderDetailsPage fillBuyerAndAddressData(Buyer buyer, Address address) {
        typeFirstName(buyer.getFirstName());
        typeLastName(buyer.getLastName());
        typeEmailAddress(buyer.getEmail());
        typePhoneNumber(buyer.getPhone());
        typeAddressPart1(address.getAddressPart1());
        typeCity(address.getCity());
        typePostCode(address.getPostCode());
        selectCountry(address.getCountry());
        selectRegionOrState(address.getRegion());
        return this;
    }

    public OrderDetailsPage clickContinueBillingDetails() {
        getDriver().findElement(By.id("button-guest")).click();
        return this;
    }

    public OrderDetailsPage typeDeliveryMethodComment(String comment) {
        getDriver().findElement(By.name("comment")).clear();
        getDriver().findElement(By.name("comment")).sendKeys(comment);
        return this;
    }

    public OrderDetailsPage clickConfirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm")));
        getDriver().findElement(By.id("button-confirm")).click();
        return this;
    }

    public OrderDetailsPage clickContinuePaymentMethod() {
        getDriver().findElement(By.id("button-payment-method")).click();
        return this;
    }

    public OrderDetailsPage agreeToTermsAndConditions() {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("agree")));
        getDriver().findElement(By.name("agree")).click();
        return this;
    }

    public OrderDetailsPage clickContinueDeliveryMethod() {
        getDriver().findElement(By.id("button-shipping-method")).click();
        return this;
    }

    private void selectRegionOrState(String region) {
        new Select(getDriver().findElement(By.id("input-payment-zone"))).selectByVisibleText(region);
    }

    private void selectCountry(String countryName) {
        new Select(getDriver().findElement(By.id("input-payment-country"))).selectByVisibleText(countryName);
    }

    private void typePostCode(String postCode) {
        getDriver().findElement(By.id("input-payment-postcode")).clear();
        getDriver().findElement(By.id("input-payment-postcode")).sendKeys(postCode);
    }

    private void typeCity(String city) {
        getDriver().findElement(By.id("input-payment-city")).clear();
        getDriver().findElement(By.id("input-payment-city")).sendKeys(city);
    }

    private void typeAddressPart1(String address) {
        getDriver().findElement(By.id("input-payment-address-1")).clear();
        getDriver().findElement(By.id("input-payment-address-1")).sendKeys(address);
    }

    private void typePhoneNumber(String phone) {
        getDriver().findElement(By.id("input-payment-telephone")).clear();
        getDriver().findElement(By.id("input-payment-telephone")).sendKeys(phone);
    }

    private void typeEmailAddress(String email) {
        getDriver().findElement(By.id("input-payment-email")).clear();
        getDriver().findElement(By.id("input-payment-email")).sendKeys(email);
    }

    private void typeLastName(String lastName) {
        getDriver().findElement(By.id("input-payment-lastname")).clear();
        getDriver().findElement(By.id("input-payment-lastname")).sendKeys(lastName);
    }

    private void typeFirstName(String firstName) {
        getDriver().findElement(By.id("input-payment-firstname")).clear();
        getDriver().findElement(By.id("input-payment-firstname")).sendKeys(firstName);
    }
}

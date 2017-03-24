package com.selenium.test.pages;

import com.selenium.test.to.Address;
import com.selenium.test.to.Buyer;
import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by SG0943274 on 2017-03-23.
 */
public class OrderDetailsPage extends BasePage {

    private WebElement accordion; // it works because id of element is "accordion'

    @FindBy(xpath = "(//input[@name='account'])[2]")
    private WebElement guestCheckoutRadioBtn;

    @FindBy(id = "button-account")
    private WebElement continueCheckoutBtn;

    @FindBy(id = "button-guest")
    private WebElement continueBillingDetailsBtn;

    @FindBy(id = "button-confirm")
    private WebElement confirmOrderBtn;

    @FindBy(id = "button-payment-method")
    private WebElement continuePaymentMethodBtn;

    @FindBy(name = "agree")
    private WebElement termsAndConditionsAgreementChbx;

    @FindBy(id = "button-shipping-method")
    private WebElement continueDeliveryMethodBtn;

    @FindBy(id = "input-payment-zone")
    private WebElement regionSelect;

    @FindBy(id = "input-payment-country")
    private WebElement countrySelect;

    public OrderDetailsPage(boolean openPageByUrl) {
        super(openPageByUrl);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return accordion.isDisplayed();
    }

    public OrderDetailsPage selectGuestCheckoutOption() {
        guestCheckoutRadioBtn.click();
        return this;
    }

    public OrderDetailsPage clickContinueCheckoutOptions() {
        continueCheckoutBtn.click();
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
        continueBillingDetailsBtn.click();
        return this;
    }

    public OrderDetailsPage typeDeliveryMethodComment(String comment) {
        getDriver().findElement(By.name("comment")).clear();                // will change when ActionBot introduced
        getDriver().findElement(By.name("comment")).sendKeys(comment);
        return this;
    }

    public OrderDetailsPage clickConfirmOrder() {
        confirmOrderBtn.click();
        return this;
    }

    public OrderDetailsPage clickContinuePaymentMethod() {
        continuePaymentMethodBtn.click();
        return this;
    }

    public OrderDetailsPage agreeToTermsAndConditions() {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("agree"))); // will change when ActionBot introduced
        getDriver().findElement(By.name("agree")).click();
        return this;
    }

    public OrderDetailsPage clickContinueDeliveryMethod() {
        continueDeliveryMethodBtn.click();
        return this;
    }

    private void selectCountry(String countryName) {
        new Select(countrySelect).selectByVisibleText(countryName);
    }

    private void selectRegionOrState(String region) {
        new Select(regionSelect).selectByVisibleText(region);
    }

    private void typePostCode(String postCode) {
        getDriver().findElement(By.id("input-payment-postcode")).clear(); // will change when ActionBot introduced
        getDriver().findElement(By.id("input-payment-postcode")).sendKeys(postCode);
    }

    private void typeCity(String city) {
        getDriver().findElement(By.id("input-payment-city")).clear(); // will change when ActionBot introduced
        getDriver().findElement(By.id("input-payment-city")).sendKeys(city);
    }

    private void typeAddressPart1(String address) {
        getDriver().findElement(By.id("input-payment-address-1")).clear(); // will change when ActionBot introduced
        getDriver().findElement(By.id("input-payment-address-1")).sendKeys(address);
    }

    private void typePhoneNumber(String phone) {
        getDriver().findElement(By.id("input-payment-telephone")).clear(); // will change when ActionBot introduced
        getDriver().findElement(By.id("input-payment-telephone")).sendKeys(phone);
    }

    private void typeEmailAddress(String email) {
        getDriver().findElement(By.id("input-payment-email")).clear(); // will change when ActionBot introduced
        getDriver().findElement(By.id("input-payment-email")).sendKeys(email);
    }

    private void typeLastName(String lastName) {
        getDriver().findElement(By.id("input-payment-lastname")).clear(); // will change when ActionBot introduced
        getDriver().findElement(By.id("input-payment-lastname")).sendKeys(lastName);
    }

    private void typeFirstName(String firstName) {
        getDriver().findElement(By.id("input-payment-firstname")).clear(); // will change when ActionBot introduced
        getDriver().findElement(By.id("input-payment-firstname")).sendKeys(firstName);
    }
}

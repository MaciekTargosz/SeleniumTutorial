package com.selenium.test.pages;

import com.selenium.test.to.Address;
import com.selenium.test.to.Buyer;
import com.selenium.test.utils.ActionBot;
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

    public OrderDetailsPage typeDeliveryMethodComment(String commentText) {
        new ActionBot(getDriver()).type(By.name("comment"), commentText);
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
        new ActionBot(getDriver()).waitUntilElementClickableAndClickOnIt(By.name("agree"), 5);
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
        new ActionBot(getDriver()).type(By.id("input-payment-postcode"), postCode);
    }

    private void typeCity(String city) {
        new ActionBot(getDriver()).type(By.id("input-payment-city"), city);
    }

    private void typeAddressPart1(String address) {
        new ActionBot(getDriver()).type(By.id("input-payment-address-1"), address);
    }

    private void typePhoneNumber(String phone) {
        new ActionBot(getDriver()).type(By.id("input-payment-telephone"), phone);
    }

    private void typeEmailAddress(String email) {
        new ActionBot(getDriver()).type(By.id("input-payment-email"), email);
    }

    private void typeLastName(String lastName) {
        new ActionBot(getDriver()).type(By.id("input-payment-lastname"), lastName);
    }

    private void typeFirstName(String firstName) {
        new ActionBot(getDriver()).type(By.id("input-payment-firstname"), firstName);
    }
}

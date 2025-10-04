package com.designpattern.proxy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CreditCardPayment implements PaymentOptions {

    @FindBy(id = "cc")
    private WebElement ccNumber;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(id = "cvv")
    private WebElement cvv;

    @Override
    public void enterPaymentDetails(Map<String, String> paymentDetails) {
        ccNumber.sendKeys(paymentDetails.get("cc"));
        year.sendKeys(paymentDetails.get("year"));
        cvv.sendKeys(paymentDetails.get("cvv"));
    }
}

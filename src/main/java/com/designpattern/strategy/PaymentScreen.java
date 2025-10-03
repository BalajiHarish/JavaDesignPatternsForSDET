package com.designpattern.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class PaymentScreen {

    private WebDriver driver;
    private UserInformation userInformation;
    private OrderSection orderSection;
    private PaymentOptions paymentOptions;

    public PaymentScreen(final WebDriver driver) {
        this.driver = driver;
        userInformation = PageFactory.initElements(driver, UserInformation.class);
        orderSection = PageFactory.initElements(driver, OrderSection.class);
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public OrderSection getOrderSection() {
        return orderSection;
    }

    public void setPaymentOptions(PaymentOptions paymentOptions) {
        this.paymentOptions = paymentOptions;
        PageFactory.initElements(driver, this.paymentOptions);
    }

    public void pay(Map<String, String> paymentDetails) {
        paymentOptions.enterPaymentDetails(paymentDetails);
    }

    public void goTo(String url) {
        driver.get(url);
    }

}

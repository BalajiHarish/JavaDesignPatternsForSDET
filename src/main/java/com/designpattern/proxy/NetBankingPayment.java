package com.designpattern.proxy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class NetBankingPayment implements PaymentOptions {

    @FindBy(id = "bank" )
    private WebElement bankName;

    @FindBy(id = "acc_number")
    private WebElement bankAccNumber;

    @FindBy(id = "pin")
    private WebElement pin;

    @Override
    public void enterPaymentDetails(Map<String, String> paymentDetails) {
        Select s = new Select(bankName);
        s.selectByVisibleText(paymentDetails.get("bank"));
        bankAccNumber.sendKeys(paymentDetails.get("acc_number"));
        pin.sendKeys(paymentDetails.get("pin"));
    }
}

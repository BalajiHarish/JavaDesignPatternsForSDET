package com.designpattern.tests.strategy;

import com.designpattern.strategy.*;
import com.designpattern.tests.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class PaymentScreenTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen() {
        paymentScreen = new PaymentScreen(driver);
    }

    @Test(dataProvider = "paymentDataProvider")
    public void paymentTest(String paymentOption, Map<String, String> paymentDetails) {
        paymentScreen.goTo("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
        paymentScreen.getUserInformation().enterUserInformation("Test", "User", "sample@gmail.com");
        paymentScreen.setPaymentOptions(PaymentOptionsFactory.get(paymentOption));
        paymentScreen.pay(paymentDetails);
        String orderNumber = paymentScreen.getOrderSection().placeOrder();
        System.out.println("Order number : " + orderNumber);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
    }

    @DataProvider
    public Object[][] paymentDataProvider() {

        Map<String, String> creditCardDetails = Maps.newHashMap();
        creditCardDetails.put("cc", "1234 5678 9876 5432");
        creditCardDetails.put("year", "2025");
        creditCardDetails.put("cvv", "123");

        Map<String, String> netBankingDetails = new HashMap<>();
        netBankingDetails.put("bank", "BOFA");
        netBankingDetails.put("acc_number", "1234567890");
        netBankingDetails.put("pin", "1234");

        return new Object[][] {
                {"CC", creditCardDetails},
                {"NB", netBankingDetails}
        };
    }
}

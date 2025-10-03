package com.designpattern.strategy;

import java.util.Map;

public interface PaymentOptions {

    void enterPaymentDetails(Map<String, String> paymentDetails);
}

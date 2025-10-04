package com.designpattern.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionsFactory {

    private static final Supplier<PaymentOptions> CC = () -> new CreditCardPayment();
    private static final Supplier<PaymentOptions> NB = () -> new NetBankingPayment();

    //supplier is a functional interface that takes no input and returns an output
    //so this is generally used when we want to create an object without any input parameters

    private static final Map<String, Supplier<PaymentOptions>> map = new HashMap<>();

    static {
        map.put("CC", CC);
        map.put("NB", NB);
    }

    public static PaymentOptions get(String option) {
        return map.get(option).get(); //get is called twice, first to get the supplier and second to get the object
    }

}

package com.designpattern.proxy;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrderComponentProxy implements OrderComponent {

    private static List<String> EXCLUDED_ENV = Arrays.asList("PROD", "STAGE");
    private OrderComponent orderComponent;

    public OrderComponentProxy(WebDriver driver) {
        String env = System.getProperty("env");
        if (!EXCLUDED_ENV.contains(env)) {
            orderComponent = new OrderComponentReal(driver);
        }
    }

    @Override
    public String placeorder() {
        if (Objects.nonNull(orderComponent)) {
            return orderComponent.placeorder();
        } else {
            return "SKIPPED";
        }
    }
}

package com.designpattern.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSection {

    @FindBy(id = "buy")
    private WebElement buy;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    public OrderSection(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String placeOrder() {
        buy.click();
        return orderNumber.getText();
    }
}

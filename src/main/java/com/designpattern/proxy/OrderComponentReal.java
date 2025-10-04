package com.designpattern.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderComponentReal implements OrderComponent {

    @FindBy(id = "buy")
    private WebElement buy;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    public OrderComponentReal(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Override
    public String placeorder() {
        buy.click();
        return orderNumber.getText();
    }
}

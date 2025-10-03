package com.designpattern.template.AmazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@id='corePriceDisplay_desktop_feature_div']//span[@class='a-price-whole']")
    private WebElement productPrice;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void getPrice() {
        wait.until((d) -> productPrice.isDisplayed());
        System.out.println("The price of the product is: " + productPrice.getText());
    }

}

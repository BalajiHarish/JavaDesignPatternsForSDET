package com.designpattern.template;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class FlipkartShopping extends ShoppingTemplate {

    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    @FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
    private WebElement searchBox;

    @FindBy(xpath = "//div[contains(@class,'yKfJKb')]")
    private WebElement openProductLink;

    @FindBy(xpath = "//div[@class='Nx9bqj CxhGGd']")
    private WebElement productPrice;

    public FlipkartShopping(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    @Override
    public void launchSite() {
        driver.get("https://www.flipkart.com/");
    }

    @Override
    public void searchProduct() {
        searchBox.sendKeys(product);
        searchBox.sendKeys(Keys.ENTER);
    }

    @Override
    public void openProduct() {
        wait.until((d) -> openProductLink.isDisplayed());
        String parentWindow = driver.getWindowHandle();
        openProductLink.click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    @Override
    public void buy() {
        wait.until((d) -> productPrice.isDisplayed());
        System.out.println("Product Price: " + productPrice.getText());
    }
}

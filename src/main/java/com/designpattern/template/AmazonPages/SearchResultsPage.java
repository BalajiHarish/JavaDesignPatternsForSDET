package com.designpattern.template.AmazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SearchResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[contains(@class,'a-link-normal')]//h2")
    private WebElement openProductLink;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
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
}

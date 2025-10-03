package com.designpattern.factory;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class GoogleEnglish extends GooglePage {
    //not putting class as public to restrict accessing in Test classes directly and this can be accessed only via Factory class

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    public GoogleEnglish(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchPage() {
        driver.get("https://www.google.com/");
    }

    @Override
    public String googleSearch(String keyword) {
        wait.until((d) -> searchBox.isDisplayed());
        searchBox.sendKeys(keyword);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(2));
        searchButton.click();
        return driver.getTitle();
    }
}

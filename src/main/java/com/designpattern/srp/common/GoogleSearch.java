package com.designpattern.srp.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearch extends AbstractComponents {

    @FindBy(name = "q")
    private WebElement searchBox;

    public GoogleSearch(final WebDriver driver) {
        super(driver);
    }

    public void enterText(String keyword) {
        searchBox.clear();
        searchBox.sendKeys(keyword);
    }

    @Override
    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        return searchBox.isDisplayed();
    }
}

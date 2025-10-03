package com.designpattern.srp.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchSuggestion extends AbstractComponents {

    @FindBy(css = "li.sbct")
    private List<WebElement> suggestionList;

    public SearchSuggestion(final WebDriver driver) {
        super(driver);
    }

    public void clickOnSuggestion(int index) {
        suggestionList.get(index - 1).click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> suggestionList.size() > 5);
        //alternative to wait.until(ExpectedConditions.visibilityOf(searchBox)); which is used from java 8
    }
}

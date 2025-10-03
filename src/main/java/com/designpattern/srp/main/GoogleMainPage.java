package com.designpattern.srp.main;

import com.designpattern.srp.common.GoogleSearch;
import com.designpattern.srp.common.SearchSuggestion;
import org.openqa.selenium.WebDriver;

public class GoogleMainPage {

    private WebDriver driver;
    private final GoogleSearch searchComponent;
    private final SearchSuggestion searchSuggestionComponent;

    public GoogleMainPage(final WebDriver driver) {
        this.driver = driver;
        this.searchComponent = new GoogleSearch(driver);
        this.searchSuggestionComponent = new SearchSuggestion(driver);
    }

    public GoogleSearch getSearchComponent() {
        return searchComponent;
    }

    public SearchSuggestion getSearchSuggestionComponent() {
        return searchSuggestionComponent;
    }

    public void goTo() {
        driver.get("https://www.google.com/");
    }
}

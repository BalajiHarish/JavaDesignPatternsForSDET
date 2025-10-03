package com.designpattern.srp.result;

import com.designpattern.srp.common.GoogleSearch;
import com.designpattern.srp.common.SearchSuggestion;
import org.openqa.selenium.WebDriver;

public class GoogleResultPage {

    private final GoogleSearch searchComponent;
    private final SearchSuggestion searchSuggestionComponent;
    private final NavigationBar navigationBar;
    private final AIOverviewSection aiOverviewSection;

    public GoogleResultPage(WebDriver driver) {
        this.navigationBar = new NavigationBar(driver);
        this.aiOverviewSection = new AIOverviewSection(driver);
        this.searchSuggestionComponent = new SearchSuggestion(driver);
        this.searchComponent = new GoogleSearch(driver);
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public AIOverviewSection getAiOverviewSection() {
        return aiOverviewSection;
    }

    public SearchSuggestion getSearchSuggestionComponent() {
        return searchSuggestionComponent;
    }

    public GoogleSearch getSearchComponent() {
        return searchComponent;
    }
}

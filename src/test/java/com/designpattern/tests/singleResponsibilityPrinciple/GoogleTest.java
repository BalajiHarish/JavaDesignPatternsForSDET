package com.designpattern.tests.singleResponsibilityPrinciple;

import com.designpattern.srp.main.GoogleMainPage;
import com.designpattern.srp.result.GoogleResultPage;
import com.designpattern.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeClass
    public void pageSetup() {
        googleMainPage = new GoogleMainPage(driver);
        googleResultPage = new GoogleResultPage(driver);
    }

    @Test(dataProvider = "getData")
    public void searchTest(String searchText, int suggestionsNumber) {
        googleMainPage.goTo();
        Assert.assertTrue(googleMainPage.getSearchComponent().isDisplayed());

        googleMainPage.getSearchComponent().enterText(searchText);
//        Assert.assertTrue(googleMainPage.getSearchSuggestionComponent().isDisplayed());
//
//        googleMainPage.getSearchSuggestionComponent().clickOnSuggestion(suggestionsNumber);
//        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());
//
//        googleMainPage.getSearchComponent().enterText(searchText);
//        Assert.assertTrue(googleMainPage.getSearchSuggestionComponent().isDisplayed());
//        googleMainPage.getSearchSuggestionComponent().clickOnSuggestion(suggestionsNumber);
//
//        System.out.println(googleResultPage.getAiOverviewSection().getAIResultContent());
//
//        googleResultPage.getNavigationBar().goToImages();
//        googleResultPage.getNavigationBar().goToVideos();

    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"Selenium", 1},
                {"Java", 2}
        };
    }
}

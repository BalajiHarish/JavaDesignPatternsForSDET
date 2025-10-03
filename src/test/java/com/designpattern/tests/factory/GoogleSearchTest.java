package com.designpattern.tests.factory;

import com.designpattern.factory.GoogleFactory;
import com.designpattern.factory.GooglePage;
import com.designpattern.tests.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private GooglePage gpage;

    @Test(dataProvider = "searchData")
    public void searchTest(String language, String keyword) {
        gpage = GoogleFactory.getGooglePage(language, driver);
        gpage.launchPage();
        String title = gpage.googleSearch(keyword);
        System.out.println("Page title is: " + title);
    }

    @DataProvider
    public Object[][] searchData() {
        return new Object[][] {
            {"ENG", "Selenium English"},
            {"FR", "Selenium French"},
            {"AR", "Selenium Arabic"}
        };
    }
}

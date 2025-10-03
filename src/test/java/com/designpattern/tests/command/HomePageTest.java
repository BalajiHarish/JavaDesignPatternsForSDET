package com.designpattern.tests.command;

import com.designpattern.command.HomePage;
import com.designpattern.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setUp() {
        homePage = new HomePage(driver);
    }

    @Test
    public void HomePageTest() {
        homePage.goTo();

//        for (ElementValidator elementValidator : homePage.getAllElementValidators()) {
//            boolean result = elementValidator.validate();
//            Assert.assertTrue(result);
//        }

        //Alternative to above for loop, in java 8 we can use streams
        homePage.getAllElementValidators()
                .stream()
                .parallel()
                .map(ev -> ev.validate())
                .forEach(b -> Assert.assertTrue(b));
    }
}

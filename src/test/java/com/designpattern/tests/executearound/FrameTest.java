package com.designpattern.tests.executearound;

import com.designpattern.executearound.MainPage;
import com.designpattern.tests.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    MainPage mainPage;

    @BeforeTest
    public void setMainPage() {
        mainPage = new MainPage(driver);
        mainPage.goTo();
    }

    @Test
    public void fillForms() {
        mainPage.inFrameA((a) -> a.setFirstName("frameAfn"));
        mainPage.inFrameB((b) -> b.setFirstName("frameBfn"));
        mainPage.inFrameA((a) -> a.setLastName("frameAln"));
        mainPage.inFrameC(c -> {
            c.setFirstName("frameCfn");
            c.setLastName("frameCln");
            c.setAddress("frameCaddress");
            c.setTextArea("frameCmessage");
        });
        mainPage.inFrameB((b) -> b.setLastName("frameBln"));
    }
}

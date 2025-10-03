package com.designpattern.srp.result;

import com.designpattern.srp.common.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponents {

    @FindBy(className = "rQTE8b")
    private WebElement navBar;

    @FindBy(xpath = "//a//*[text()='Images']")
    private WebElement imagesLink;

    @FindBy(xpath = "//a//*[text()='Videos']")
    private WebElement videosLink;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToImages() {
        imagesLink.click();
    }

    public void goToVideos() {
        videosLink.click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> navBar.isDisplayed());
    }
}

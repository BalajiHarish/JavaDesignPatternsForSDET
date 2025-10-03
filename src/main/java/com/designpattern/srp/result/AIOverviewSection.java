package com.designpattern.srp.result;

import com.designpattern.srp.common.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AIOverviewSection extends AbstractComponents {

    @FindBy(xpath = "//div[@jsname='txosbe']")
    private WebElement aiOverviewSection;

    @FindBy(xpath = "(//div[@jsname='PLkxOb']//span[text()])[1]")
    private WebElement aiResultContent;

    public AIOverviewSection(final WebDriver driver) {
        super(driver);
    }

    public String getAIResultContent() {
        return aiResultContent.getText();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d) -> aiOverviewSection.isDisplayed());
    }
}

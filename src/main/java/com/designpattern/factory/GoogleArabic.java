package com.designpattern.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleArabic extends GoogleEnglish {

    public GoogleArabic(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchPage() {
        driver.get("https://www.google.com.sa");
    }

    @Override
    public String googleSearch(String keyword) {
        System.out.println("Performing search in Arabic language");
        return super.googleSearch(keyword);
    }
}

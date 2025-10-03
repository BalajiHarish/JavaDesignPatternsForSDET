package com.designpattern.factory;

import org.openqa.selenium.WebDriver;

class GoogleFrench extends GoogleEnglish {

    public GoogleFrench(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchPage() {
        driver.get("https://www.google.fr/");
    }
}

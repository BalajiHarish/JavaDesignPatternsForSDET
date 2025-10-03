package com.designpattern.tests;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quitDriver() {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
        driver.quit();
    }
}

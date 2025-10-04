package com.designpattern.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformation {

    @FindBy(id = "fn")
    private WebElement firstName;

    @FindBy(id = "ln")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    public UserInformation(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterUserInformation(String firstName, String lastName, String email) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
    }
}

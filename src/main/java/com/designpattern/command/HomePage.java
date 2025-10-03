package com.designpattern.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private final WebDriver driver;

    //Alert buttons

    @FindBy(css = "div.button-box button.btn-info")
    private WebElement infoButton;

    @FindBy(css = "div.button-box button.btn-warning")
    private WebElement warningButton;

    @FindBy(css = "div.button-box button.btn-success")
    private WebElement successButton;

    @FindBy(css = "div.button-box button.btn-danger")
    private WebElement dangerButton;

    //Notification alerts

    @FindBy(css = "div.jq-icon-info")
    private WebElement infoNotification;

    @FindBy(css = "div.jq-icon-warning")
    private WebElement warningNotification;

    @FindBy(css = "div.jq-icon-success")
    private WebElement successNotification;

    @FindBy(css = "div.jq-icon-error")
    private WebElement errorNotification;

    //Dismissable alerts

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[@class='alert alert-success']")
    private WebElement dismissableSuccessAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[@class='alert alert-info']")
    private WebElement dismissableInfoAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[@class='alert alert-warning']")
    private WebElement dismissableWarningAlert;

    @FindBy(xpath = "//h4[text()='Dissmissal Alert']//following-sibling::div[@class='alert alert-danger']")
    private WebElement dismissableDangerAlert;

    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
    }

    public List<ElementValidator> getAllElementValidators() {

        List<ElementValidator> validators = new ArrayList<>();

        // Notification Validators
        validators.add(new NotificationValidator(infoButton, infoNotification));
        validators.add(new NotificationValidator(warningButton, warningNotification));
        validators.add(new NotificationValidator(successButton, successNotification));
        validators.add(new NotificationValidator(dangerButton, errorNotification));

        // Alert Validators
        validators.add(new DismissableElementValidator(dismissableSuccessAlert));
        validators.add(new DismissableElementValidator(dismissableInfoAlert));
        validators.add(new DismissableElementValidator(dismissableWarningAlert));
        validators.add(new DismissableElementValidator(dismissableDangerAlert));

        return validators;
    }

}

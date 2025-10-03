package com.designpattern.command;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class NotificationValidator extends ElementValidator {

    private final WebElement button;
    private final WebElement notification;

    public NotificationValidator(final WebElement button, final WebElement notification) {
        this.button = button;
        this.notification = notification;
    }

    @Override
    public boolean validate() {
        button.click();
        boolean isDisplayed = notification.isDisplayed();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(4));
        boolean isNotDisplayed = notification.isDisplayed();
        return isDisplayed && (!isNotDisplayed);
    }
}

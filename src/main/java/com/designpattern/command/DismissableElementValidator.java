package com.designpattern.command;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class DismissableElementValidator extends ElementValidator {

    private final WebElement dismissableElement;

    public DismissableElementValidator(final WebElement dismissableElement) {
        this.dismissableElement = dismissableElement;
    }

    @Override
    public boolean validate() {
        boolean defaultState = dismissableElement.isDisplayed();
        dismissableElement.findElement(By.cssSelector("button.close")).click();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
        boolean afterDismissState;
        try {
            afterDismissState = dismissableElement.isDisplayed();
        } catch (NoSuchElementException e) {
            afterDismissState = false;
        }
        return defaultState && (!afterDismissState);
    }
}

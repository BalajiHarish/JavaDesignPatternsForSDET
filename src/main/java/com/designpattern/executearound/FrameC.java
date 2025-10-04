package com.designpattern.executearound;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameC {

    @FindBy(name = "fn")
    private WebElement firstName;

    @FindBy(name = "ln")
    private WebElement lastName;

    @FindBy(name = "addr")
    private WebElement address;

    @FindBy(id = "area")
    private WebElement textArea;

    public void setFirstName(String fn) {
        firstName.sendKeys(fn);
    }

    public void setLastName(String ln) {
         lastName.sendKeys(ln);
    }

    public void setAddress(String add) {
        address.sendKeys(add);
    }

    public void setTextArea(String message) {
        textArea.sendKeys(message);
    }
}

package com.designpattern.executearound;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Consumer;

public class MainPage {

    private WebDriver driver;

    @FindBy(id = "a")
    private WebElement frameA;

    @FindBy(id = "b")
    private WebElement frameB;

    @FindBy(id = "c")
    private WebElement frameC;

    FrameA fA;
    FrameB fB;
    FrameC fC;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        fA = PageFactory.initElements(driver, FrameA.class);
        fB = PageFactory.initElements(driver, FrameB.class);
        fC = PageFactory.initElements(driver, FrameC.class);
    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/main.html");
    }

//    public FrameA inFrameA() {
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame(frameA);
//        return fA;
//    }

    //Here instead of returning FrameA, we are accepting a Consumer functional interface
    //which will take FrameA as input and perform the operations defined in the lambda expression
    //This way we ensure that the switch to default content is always executed after the operations
    //are performed on FrameA because if we forget to switch back, it can lead to issues in subsequent operations
    //especially when dealing with multiple frames with their objects in test classes.

    //Consumer is a functional interface introduced in Java 8 that represents an operation that accepts a single input argument and returns no result.
    //It is typically used to perform operations on a single object without returning any value.

    public void inFrameA(Consumer<FrameA> consumer) {
        driver.switchTo().frame(frameA);
        consumer.accept(fA);
        driver.switchTo().defaultContent();
    }

    public void inFrameB(Consumer<FrameB> consumer) {
        driver.switchTo().frame(frameB);
        consumer.accept(fB);
        driver.switchTo().defaultContent();
    }

    public void inFrameC(Consumer<FrameC> consumer) {
        driver.switchTo().frame(frameC);
        consumer.accept(fC);
        driver.switchTo().defaultContent();
    }
}

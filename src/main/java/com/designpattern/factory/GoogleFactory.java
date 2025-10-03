package com.designpattern.factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class GoogleFactory {

//    public static GooglePage getGooglePage(String lang, WebDriver driver) {
//        if (lang.equalsIgnoreCase("FR")) {
//            return new GoogleFrench(driver);
//        } else {
//            return new GoogleEnglish(driver);
//        }
//    } //Instead of this try java 8 Supplier

    private static final Map<String, Function<WebDriver, GooglePage>> map = new HashMap<>();

    public static final Function<WebDriver, GooglePage> ENG = (d) -> new GoogleEnglish(d);
    public static final Function<WebDriver, GooglePage> FR = (d) -> new GoogleFrench(d);
    public static final Function<WebDriver, GooglePage> AR = (d) -> new GoogleArabic(d);

    static {
        map.put("FR", FR);
        map.put("AR", AR);
        map.put("ENG", ENG);
    }

    public static GooglePage getGooglePage(String lang, WebDriver driver) {
        return map.get(lang).apply(driver); //apply method will execute this ----> (driver) -> new GoogleEnglish(driver)
    }
}

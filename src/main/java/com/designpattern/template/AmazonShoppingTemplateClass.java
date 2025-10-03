package com.designpattern.template;

import com.designpattern.template.AmazonPages.ProductPage;
import com.designpattern.template.AmazonPages.SearchPage;
import com.designpattern.template.AmazonPages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonShoppingTemplateClass extends ShoppingTemplate {

    private WebDriver driver;
    private String product;

    private ProductPage pp;
    private SearchPage sp;
    private SearchResultsPage srp;

    public AmazonShoppingTemplateClass(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        pp = PageFactory.initElements(driver, ProductPage.class);
        sp = PageFactory.initElements(driver, SearchPage.class);
        srp = PageFactory.initElements(driver, SearchResultsPage.class);
    }

    @Override
    public void launchSite() {
        sp.goTo();
    }

    @Override
    public void searchProduct() {
        sp.search(product);
    }

    @Override
    public void openProduct() {
        srp.selectProduct();
    }

    @Override
    public void buy() {
        pp.getPrice();
    }
}

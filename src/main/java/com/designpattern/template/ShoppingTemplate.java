package com.designpattern.template;

public abstract class ShoppingTemplate {

    public abstract void launchSite();
    public abstract void searchProduct();
    public abstract void openProduct();
    public abstract void buy();

    public void shop() {
        launchSite();
        searchProduct();
        openProduct();
        buy();
    }
}

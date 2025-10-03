package com.designpattern.tests.template;

import com.designpattern.template.AmazonShoppingTemplateClass;
import com.designpattern.template.FlipkartShopping;
import com.designpattern.template.ShoppingTemplate;
import com.designpattern.tests.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {

    @Test(dataProvider = "shoppingData")
    public void testShopping(ShoppingTemplate st) {
        st.shop();
    }

    @DataProvider
    public Object[] shoppingData() {
        return new Object[] {
                new AmazonShoppingTemplateClass(driver, "iPhone 17"),
                new FlipkartShopping(driver, "iPhone 17")
        };
    }
}

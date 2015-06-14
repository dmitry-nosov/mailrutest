
package com.mailrutests.pages;

import org.openqa.selenium.WebDriver;

public class BasePageWithMenu extends BasePage {

    private WebDriver driver;

    public BasePageWithMenu(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public MenuPage getMenu() {

        return new MenuPage(driver);
    }
}

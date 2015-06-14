
package com.mailrutests.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage extends BasePage {

    @AndroidFindBy(id = "ru.mail.mailapp:id/swipe")
    private MobileElement menuOpenBox;

    @AndroidFindBy(id = "ru.mail.mailapp:id/folder_list")
    private MobileElement menuCloseBox;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Navigate up\")")
    private MobileElement menuBtn;

    public MenuPage(WebDriver driver) {
        super(driver);
        checkIfDisplayed(new ArrayList<WebElement>() {
            {
                add(menuOpenBox);
                add(menuBtn);
            }
        });

    }

    public MenuPage openMenu() {
        menuOpenBox.swipe(SwipeElementDirection.RIGHT, BasePage.SWIPE_INDENT,
                BasePage.SWIPE_INDENT, BasePage.SWIPE_DURATION);
        return this;
    }

    public void closeMenu() {
        menuCloseBox.swipe(SwipeElementDirection.LEFT, BasePage.SWIPE_DURATION);
    }
}

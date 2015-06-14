
package com.mailrutests.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mailrutests.util.PropertiesStorage;

public class BasePage {

    public static final int SWIPE_DURATION = 1000;

    public static final int SWIPE_INDENT = 10; // the distance to left and right

    // before the ENF exception

    private WebDriver driver;

    // borders when swiping

    public BasePage(WebDriver driver) {
        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Integer.parseInt(PropertiesStorage.getInstance()
                        .getProperty("tests.waitTimeout")), TimeUnit.SECONDS), this);
        this.driver = driver;
    }

    public void checkIfDisplayed(List<WebElement> elementsList) throws AssertionError {
        try {
            for (WebElement el : elementsList) {
                Assert.assertTrue(el.isDisplayed());
            }
        } catch (NoSuchElementException e) {
            throw new AssertionError("Failed to load page: " + this.toString() + ", reason: "
                    + e.getMessage());
        }
    }
}

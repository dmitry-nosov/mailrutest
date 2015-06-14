
package com.mailrutests.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MoveToFolderPage extends BasePage {

    public MoveToFolderPage(WebDriver driver) {
        super(driver);
        checkIfDisplayed(new ArrayList<WebElement>() {
            {
                add(dialogTitle);
                // TODO: Add the compose mail icon to constructor
            }
        });
        Assert.assertEquals("Move to Folder", dialogTitle.getText());
    }

    @AndroidFindBy(id = "ru.mail.mailapp:id/alertTitle")
    private MobileElement dialogTitle;

}

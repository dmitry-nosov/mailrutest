
package com.mailrutests.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComposeMessagePage extends BasePage {

    private WebDriver driver;

    public ComposeMessagePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        checkIfDisplayed(new ArrayList<WebElement>() {
            {
                add(sendMessageIcon);
                add(cancelBtn);
            }
        });
    }

    @AndroidFindBy(id = "ru.mail.mailapp:id/toolbar_action_send")
    private MobileElement sendMessageIcon;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Navigate up\")")
    private MobileElement cancelBtn;

    public InboxPage cancelCompose() {
        cancelBtn.click();
        return new InboxPage(driver);
    }
}

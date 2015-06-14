
package com.mailrutests.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TutorialPage extends BasePage {

    @AndroidFindBy(id = "ru.mail.mailapp:id/tutorial_view")
    MobileElement tutorialPopup;

    private WebDriver driver;

    public TutorialPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        checkIfDisplayed(new ArrayList<WebElement>() {
            {
                add(tutorialPopup);
            }
        });
        // Could also check ru.mail.mailapp:id/tutorial_text and the like but I
        // think that strategically it is better to leave this to layout checks
        // (through image comparing)
    }

    public InboxPage closeTutorial() {
        tutorialPopup.click();

        return new InboxPage(driver);

    }

}

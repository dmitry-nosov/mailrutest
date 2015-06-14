
package com.mailrutests.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mailrutests.util.PropertiesStorage;

public class InboxPage extends BasePageWithMenu {

    public static final int MESSAGE_ACTIONS_COUNT = 5;

    private WebDriver driver;

    public InboxPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        checkIfDisplayed(new ArrayList<WebElement>() {
            {
                add(messagesList.get(0));
                // TODO: Add the compose mail icon to constructor
            }
        });

    }

    @AndroidFindBy(id = "ru.mail.mailapp:id/qa_viewgroup")
    private List<MobileElement> messagesList;

    @AndroidFindBy(id = "ru.mail.mailapp:id/checkbox")
    private List<MobileElement> messagesLogo;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"ru.mail.mailapp:id/qa_viewgroup\"]/android.view.View/android.widget.ImageButton")
    private List<MobileElement> actionIcons;

    @AndroidFindBy(id = "ru.mail.mailapp:id/toolbar_action_new")
    private MobileElement composeMessageIcon;

    public InboxPage openActionsOfMessage(int emailNumber) {

        messagesList.get(emailNumber).swipe(SwipeElementDirection.LEFT, BasePage.SWIPE_INDENT,
                BasePage.SWIPE_INDENT, BasePage.SWIPE_DURATION);

        new WebDriverWait(driver, Integer.parseInt(PropertiesStorage.getInstance().getProperty(
                "tests.waitTimeout"))).until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        if (actionIcons.size() == MESSAGE_ACTIONS_COUNT)
                            return true;
                        else
                            return false;
                    }
                });
        return this;
    }

    public void assertTotalActionsNumberEquals(int iconsNumber) {

        Assert.assertEquals(iconsNumber, actionIcons.size());
    }

    public InboxPage closeActionsOfMessage(int emailNumber) {
        messagesList.get(emailNumber).swipe(SwipeElementDirection.RIGHT, BasePage.SWIPE_INDENT,
                BasePage.SWIPE_INDENT, BasePage.SWIPE_DURATION);

        new WebDriverWait(driver, Integer.parseInt(PropertiesStorage.getInstance().getProperty(
                "tests.waitTimeout"))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                if (actionIcons.size() == 0)
                    return true;
                else
                    return false;
            }
        });

        return this;
    }

    public MoveToFolderPage openFolders() {
        actionIcons.get(2).click();
        return new MoveToFolderPage(driver);
    }

    public InboxPage selectMessageLogo(int logoNumber) {
        messagesLogo.get(logoNumber).click();
        return this;
    }

    public ComposeMessagePage composeMessage() {
        composeMessageIcon.click();
        return new ComposeMessagePage(driver);
    }

}

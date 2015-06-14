
package com.mailrutests.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.mailrutests.pages.ComposeMessagePage;
import com.mailrutests.pages.InboxPage;
import com.mailrutests.pages.MenuPage;
import com.mailrutests.pages.TutorialPage;
import com.mailrutests.util.PropertiesStorage;

public class TestAssignmentTests {

    static AndroidDriver driver;

    @Before
    public void setUp() throws Exception {

        File appDir = new File(PropertiesStorage.getInstance().getProperty("capability.appPath"));
        File app = new File(appDir, PropertiesStorage.getInstance().getProperty(
                "capability.appName"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesStorage
                .getInstance().getProperty("capability.deviceName"));
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, PropertiesStorage
                .getInstance().getProperty("capability.appActivity"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertiesStorage
                .getInstance().getProperty("capability.platformName"));

        driver = new AndroidDriver(new URL(PropertiesStorage.getInstance().getProperty(
                "capability.serverUrl")), capabilities);

        if (PropertiesStorage.getInstance().getProperty("tests.orientation")
                .equalsIgnoreCase("landscape")) {
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test0001MessageActionsAppear() {
        TutorialPage tutorialPage = new TutorialPage(driver);
        InboxPage inboxPage = tutorialPage.closeTutorial();
        inboxPage.openActionsOfMessage(0);
        inboxPage.assertTotalActionsNumberEquals(InboxPage.MESSAGE_ACTIONS_COUNT);
    }

    @Test
    public void test0002MessageActionsClosedByMenu() {
        TutorialPage tutorialPage = new TutorialPage(driver);
        InboxPage inboxPage = tutorialPage.closeTutorial();
        MenuPage menuPage = inboxPage.getMenu();
        inboxPage.openActionsOfMessage(0);
        menuPage.openMenu();
        inboxPage.assertTotalActionsNumberEquals(0);
    }

    @Test
    public void test0003MessageActionsClosedOnActionTap() {
        TutorialPage tutorialPage = new TutorialPage(driver);
        InboxPage inboxPage = tutorialPage.closeTutorial();
        inboxPage.openActionsOfMessage(0);
        inboxPage.openFolders();
        inboxPage.assertTotalActionsNumberEquals(0);
    }

    @Test
    public void test0004MessageActionsClosedOnOpeningOtherMessageActions() {
        TutorialPage tutorialPage = new TutorialPage(driver);
        InboxPage inboxPage = tutorialPage.closeTutorial();
        inboxPage.openActionsOfMessage(0);
        inboxPage.openActionsOfMessage(1);
        inboxPage.assertTotalActionsNumberEquals(InboxPage.MESSAGE_ACTIONS_COUNT);
    }

    @Test
    public void test0005MessageActionsClosedOnMessageListEdit() {
        TutorialPage tutorialPage = new TutorialPage(driver);
        InboxPage inboxPage = tutorialPage.closeTutorial();
        inboxPage.openActionsOfMessage(0);
        inboxPage.selectMessageLogo(0);
        inboxPage.assertTotalActionsNumberEquals(0);
    }

    @Test
    public void test0006MessageActionsClosedOnCompose() {
        TutorialPage tutorialPage = new TutorialPage(driver);
        InboxPage inboxPage = tutorialPage.closeTutorial();
        inboxPage.openActionsOfMessage(0);
        ComposeMessagePage composeMessagePage = inboxPage.composeMessage();
        inboxPage = composeMessagePage.cancelCompose();
        inboxPage.assertTotalActionsNumberEquals(0);
    }

    @Test
    public void test0007MessageActionsClosedOnSwipeRight() {
        TutorialPage tutorialPage = new TutorialPage(driver);
        InboxPage inboxPage = tutorialPage.closeTutorial();
        inboxPage.openActionsOfMessage(0);
        inboxPage.closeActionsOfMessage(0);
        inboxPage.assertTotalActionsNumberEquals(0);
    }
}

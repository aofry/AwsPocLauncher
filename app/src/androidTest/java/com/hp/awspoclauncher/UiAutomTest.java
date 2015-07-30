package com.hp.awspoclauncher;

import android.content.Context;
import android.content.Intent;
import android.support.test.uiautomator.*;
import android.test.InstrumentationTestCase;

import org.junit.*;

import java.io.File;


public class UiAutomTest extends InstrumentationTestCase {

    private UiDevice uiDevice;

    @Before
    public void setUp() {
        // Initialize UiDevice instance
        uiDevice = UiDevice.getInstance(getInstrumentation());

        // Start from the home screen
        //uiDevice.pressHome();
        //uiDevice.wait(Until.hasObject(By.pkg(getHomeScreenPackage()).depth(0)),
        Context context = getInstrumentation().getContext();
        Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage("com.hp.awspoclauncher");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        // Clear out any previous instances
        context.startActivity(intent);
        uiDevice.wait(Until.hasObject(By.pkg("com.hp.awspoclauncher").depth(0)), 10000);
    }

    @Test
    public void testGetWebData() throws UiObjectNotFoundException {
        uiDevice.findObject(new UiSelector().text("ClickMe"))
                .click();
        uiDevice.waitForIdle(5000);

        UiObject displayTextField = uiDevice.findObject(new UiSelector().descriptionContains("display text"));


        assertTrue(displayTextField.getText().indexOf("GOOG") > 0);

        //boolean screenshotRes = uiDevice.takeScreenshot(new File("/sdcard/home-screen-1234.png"), 1, 10);
        //assertTrue(screenshotRes);
    }

    @Test
    public void testLaunchAut() throws UiObjectNotFoundException {

        uiDevice.findObject(new UiSelector().text("Launch AUT"))
                .click();
    }
}

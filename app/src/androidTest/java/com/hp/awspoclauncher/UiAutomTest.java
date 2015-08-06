package com.hp.awspoclauncher;

import android.content.Context;
import android.content.Intent;
import android.support.test.uiautomator.*;
import android.test.InstrumentationTestCase;

import org.junit.*;

import java.io.File;
import java.util.Iterator;


public class UiAutomTest extends UiAutomatorTestCase {

    private UiDevice uiDevice;
    private String serverUrl;

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

        //this.serverUrl = getParams().getString("server");
    }

    //@Test
    public void GetWebData() throws UiObjectNotFoundException {
        uiDevice.findObject(new UiSelector().text("ClickMe"))
                .click();
        uiDevice.waitForIdle(5000);

        UiObject displayTextField = uiDevice.findObject(new UiSelector().descriptionContains("display text"));


        assertTrue(displayTextField.getText().indexOf("GOOG") > 0);

        //boolean screenshotRes = uiDevice.takeScreenshot(new File("/sdcard/home-screen-1234.png"), 1, 10);
        //assertTrue(screenshotRes);
    }

    //@Test
    public void LaunchAut() throws UiObjectNotFoundException {

        uiDevice.findObject(new UiSelector().text("Launch AUT"))
                .click();

        uiDevice.waitForIdle(10000);

        uiDevice.findObject(new UiSelector().text("presto"))
                .click();

        uiDevice.waitForIdle(5000);

        UiObject displayTextField = uiDevice.findObject(new UiSelector().descriptionContains("autText"));


        assertTrue(displayTextField.getText().indexOf("1") >= 0);

    }

    //@Test
    public void Stalling() throws UiObjectNotFoundException {

        uiDevice.findObject(new UiSelector().text("Launch AUT"))
                .click();

        uiDevice.waitForIdle(10000);

        for (int i =1; i< 12; i++) {
            uiDevice.findObject(new UiSelector().text("presto"))
                    .click();

            uiDevice.waitForIdle(5000);

            UiObject displayTextField = uiDevice.findObject(new UiSelector().descriptionContains("autText"));


            assertTrue(displayTextField.getText().indexOf(i + "") >= 0);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testParams() throws UiObjectNotFoundException {
        //String stringValue = getParams().getString("stringKey");

        //String stringValue = System.getProperties().propertyNames().nextElement().toString();
        String stringValue = System.getProperty("prop");
        System.out.println("got string: " + stringValue);
        UiObject displayTextField = uiDevice.findObject(new UiSelector().descriptionContains("editMe"));

        displayTextField.setText(stringValue);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stringValue = getParams().getString("prop");

        displayTextField.setText(stringValue);


    }
}

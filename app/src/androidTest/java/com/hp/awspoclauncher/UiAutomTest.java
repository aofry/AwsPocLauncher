package com.hp.awspoclauncher;

import android.content.Context;
import android.content.Intent;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.test.InstrumentationTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.By;

import org.junit.*;


public class UiAutomTest extends InstrumentationTestCase {

    private UiDevice mDevice;

    @Before
    public void setUp() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(getInstrumentation());

        // Start from the home screen
        //mDevice.pressHome();
        //mDevice.wait(Until.hasObject(By.pkg(getHomeScreenPackage()).depth(0)),
        Context context = getInstrumentation().getContext();
        Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage("com.hp.awspoclauncher");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        // Clear out any previous instances
        context.startActivity(intent);
        mDevice.wait(Until.hasObject(By.pkg("com.hp.awspoclauncher").depth(0)), 10000);
    }

    @Test
    public void testTwoPlusThreeEqualsFive() throws UiObjectNotFoundException {
        mDevice.findObject(new UiSelector().text("ClickMe"))
                .click();
        mDevice.findObject(new UiSelector().text("Launch AUT"))
                .click();


    }
}

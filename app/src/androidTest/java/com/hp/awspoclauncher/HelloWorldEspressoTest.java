package com.hp.awspoclauncher;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.Button;

import org.junit.*;
import org.junit.runner.RunWith;

/**
 * Created by ofry on 7/23/2015.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HelloWorldEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    public void listGoesOverTheFold() {
        //onView(withText("Hello world!")).check(matches(isDisplayed()));
        ((Button)mActivityRule.getActivity().findViewById(R.id.getDataBtn)).performClick();
    }
}

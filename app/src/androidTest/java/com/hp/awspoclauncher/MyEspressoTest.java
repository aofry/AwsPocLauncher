package com.hp.awspoclauncher;

import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.*;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

//import org.junit.Before;

public class MyEspressoTest
        //extends ActivityInstrumentationTestCase2<MainActivity>
{

    private MainActivity mainActivity;

    public MyEspressoTest() {

    }

    @Before
    public void setUp() throws Exception {
//        super.setUp();
//        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
//        mainActivity = getActivity();
    }

    @Test
    public void testChangeText_sameActivity() {
        // Type text and then press the button.
        //onView(withId(R.id.locationText))
        //        .perform(typeText("aaa"), closeSoftKeyboard());
        onView(withId(R.id.getDataBtn)).perform(click());

        // Check that the text was changed.

    }

}

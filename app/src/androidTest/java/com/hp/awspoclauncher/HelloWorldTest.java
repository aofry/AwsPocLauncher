package com.hp.awspoclauncher;

import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

//import org.junit.Before;

public class HelloWorldTest
        extends ActivityInstrumentationTestCase2<MainActivity>
{

    private MainActivity mainActivity;

    public HelloWorldTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mainActivity = getActivity();
    }

}

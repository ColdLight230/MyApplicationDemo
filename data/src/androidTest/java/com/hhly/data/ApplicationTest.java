package com.hhly.data;

import android.app.Application;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.test.ApplicationTestCase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.hhly.myapplicationdemo.data.test", appContext.getPackageName());
    }
}
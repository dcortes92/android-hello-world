package com.sqisland.android.hello;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by danielcortes on 4/6/16.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule
            = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void bye() {
        Espresso.onView(ViewMatchers.withId(R.id.greeting))
                .check(ViewAssertions.matches(ViewMatchers.withText(R.string.hello_world)));

        Espresso.openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        Espresso.onView(ViewMatchers.withText(R.string.say_bye))
                .perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.greeting))
                .check(ViewAssertions.matches(ViewMatchers.withText(R.string.bye)));
    }
}
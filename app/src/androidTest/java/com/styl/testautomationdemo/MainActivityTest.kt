package com.styl.testautomationdemo

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by NguyenHang on 4/4/2020.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class MainActivityTest {
    @Rule
    @JvmField
    var mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun navigationSecondActivity() {
        Espresso.onView(ViewMatchers.withId(R.id.btn_navigation))
            .perform(click())
    }
}
package com.styl.testautomationdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.styl.testautomationdemo.second.SecondActivity

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by NguyenHang on 4/4/2020.
 */
@RunWith(AndroidJUnit4ClassRunner ::class)
@LargeTest
class SecondActivityTest {
    @Rule
    @JvmField
    var secondActivity = ActivityTestRule(SecondActivity::class.java)

    @Test
    fun login_validUsername() {
        onView(withId(R.id.edt_username)).perform(ViewActions.typeText("hang1234"), closeSoftKeyboard())
        onView(withId(R.id.btn_login)).perform(click())
        onView(withId(R.id.tv_status)).check(matches(withText("Success")))
    }

    @Test
    fun login_invalidUsername() {
        onView(withId(R.id.edt_username)).perform(ViewActions.typeText(""), closeSoftKeyboard())
        onView(withId(R.id.btn_login)).perform(click())
        onView(withId(R.id.tv_status)).check(matches(withText("Fail")))
    }
}
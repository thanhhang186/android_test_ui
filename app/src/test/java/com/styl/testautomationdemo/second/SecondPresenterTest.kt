package com.styl.testautomationdemo.second

import com.styl.testautomationdemo.Service
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by NguyenHang on 4/20/2020.
 */
@RunWith(MockitoJUnitRunner::class)
class SecondPresenterTest {
    @Mock
    private lateinit var view: ISecondContact.View
    @Spy
    private lateinit var service: Service
    private lateinit var presenter: SecondPresenter

    @Before
    fun onSetup() {
        presenter = SecondPresenter(view, service)
    }

    @Test
    fun isValidUserNameTest_valid() {
        assert(presenter.isValidUserName("hello123"))
    }

    @Test
    fun isValidUserNameTest_empty() {
        assert(!presenter.isValidUserName("  "))
    }

    @Test
    fun isValidUserNameTest_inValidLength() {
        assert(!presenter.isValidUserName("hel"))
    }

    @Test
    fun getFriendListByFilterTest_success() {
        //        `when`(service.getFriendList(ArgumentMatchers.anyInt())).thenReturn(
//            null
//        )
        val responseEven = presenter.getFriendListByFilter(false)
        Assert.assertEquals(5, responseEven.size)

        val responseOdd = presenter.getFriendListByFilter(true)
        Assert.assertEquals(5, responseOdd.size)
    }
}
package com.android.app.machinetestdiagonal

import android.content.Context
import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.android.app.machinetestdiagonal.ui.home.Home
import com.android.app.machinetestdiagonal.utils.ApiProvider
import com.android.app.machinetestdiagonal.utils.Constants
import com.android.app.machinetestdiagonal.utils.Utils
import com.google.common.truth.Truth
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule
import org.junit.BeforeClass







@RunWith(AndroidJUnit4::class)
class HomeTest {
    private val TAG = "HomeTest"
    lateinit var instrumentationContext: Context

    @Before
    fun setUp() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

//    @Test
//    suspend fun getFilmDataByInvalidFileName() {
//        val filename = ""
//        val result = ApiProvider.getJsonFromAssets(instrumentationContext, filename)
//        Truth.assertThat(result)
//    }

//    @BeforeClass
//    fun createEntities() {
//        // Setup...
//    }

//    @Test
//    suspend fun getFilmDataByFileName() {
//        val filename = Constants.page1
//        val result = ApiProvider.getJsonFromAssets(instrumentationContext, filename)
//        Truth.assertThat(result)
//    }

    @Test
    fun convertPXDP() {
        val dp = 1f
        var result = Utils.pxFromDp(instrumentationContext, dp)
        Log.d(TAG, "checkDpToPxConversions: ${result}")
        Truth.assertThat(result)


        val px = 90f
        result = instrumentationContext.let { Utils.dpFromPx(it, px) }
        Log.d(TAG, "checkPxToDpConversions: $result")
        Truth.assertThat(result)
    }

    @After
    fun tearDown() {

    }
}
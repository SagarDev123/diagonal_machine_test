package com.android.app.machinetestdiagonal.utils



import android.content.Context
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import androidx.test.core.app.ApplicationProvider;

@RunWith(JUnit4::class)
class UtilsTest {

    private  val TAG = "UtilsTest"

    @Test
    fun checkDpToPxConversions() {
        val dp = 100f
      //  private Context context = ApplicationProvider.getApplicationContext();

        val context :Context = ApplicationProvider.getApplicationContext()

        val result =  Utils.pxFromDp(context, dp)
       Log.d(TAG, "checkDpToPxConversions: ${result}")
        assertThat(result)
    }

    @Test
    fun checkPxToDpConversions() {
        val px = 100f
        val context :Context = ApplicationProvider.getApplicationContext()
        val result = context.let { Utils.dpFromPx(it, px) }
        Log.d(TAG, "checkPxToDpConversions: $result")
        assertThat(result)
    }
}
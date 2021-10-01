package com.android.app.machinetestdiagonal.utils
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class UtilsTest {

    private  val TAG = "UtilsTest"
    @Test
    fun checkQueryValidation() {
        val query: String = "Film"
        val result = Utils.checkIfQueryIsValid(query)
        assertThat(result)
    }
}
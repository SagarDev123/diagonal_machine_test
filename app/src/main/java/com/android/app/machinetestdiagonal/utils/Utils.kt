package com.android.app.machinetestdiagonal.utils

import android.content.Context

object Utils {
    fun dpFromPx(context: Context, px: Float): Float {
        return px / context.resources.displayMetrics.density
    }

    fun pxFromDp(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }

    fun checkIfQueryIsValid(query: String?): Boolean {
        return !query.isNullOrEmpty()
    }
}
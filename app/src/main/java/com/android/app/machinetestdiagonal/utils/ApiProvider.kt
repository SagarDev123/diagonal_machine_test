package com.android.app.machinetestdiagonal.utils

import android.content.Context
import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets

object ApiProvider {
   suspend fun getJsonFromAssets(context: Context, fileName: String): String? {
        val jsonString: String = try {
            val `is`: InputStream = context.assets.open(fileName)
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, StandardCharsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return jsonString
    }
}
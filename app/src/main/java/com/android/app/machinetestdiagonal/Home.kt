package com.android.app.machinetestdiagonal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.app.machinetestdiagonal.utils.ApiProvider
import com.android.app.machinetestdiagonal.utils.Constants

class Home : AppCompatActivity() {
    private  val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ${ApiProvider.getJsonFromAssets(this,Constants.page1)}")
    }
}
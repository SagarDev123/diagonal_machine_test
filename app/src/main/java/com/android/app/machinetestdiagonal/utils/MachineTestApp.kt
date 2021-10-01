package com.android.app.machinetestdiagonal.utils

import android.app.Application
import com.microsoft.appcenter.crashes.Crashes
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.AppCenter

class MachineTestApp:Application() {
    override fun onCreate() {
        super.onCreate()
         instance = this
        AppCenter.start(
           this, "876cdc0d-6f87-4b31-b62b-cb30dd96ffd9",
            Analytics::class.java, Crashes::class.java
        )
    }
    companion object{
        var instance :MachineTestApp? =null
    }

}
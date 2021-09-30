package com.android.app.machinetestdiagonal.utils

import android.app.Application

class MachineTestApp:Application() {
    override fun onCreate() {
        super.onCreate()
         instance = this
    }
    companion object{
        var instance :MachineTestApp? =null
    }

}
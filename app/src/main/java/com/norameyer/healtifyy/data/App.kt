package com.norameyer.healtifyy.data

import android.app.Application

class App : Application() {
    val database by lazy { MainDB.createDatabase(this) }
}
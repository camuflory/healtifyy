package com.norameyer.healtifyy.classes

import android.app.Application
import com.norameyer.healtifyy.data.MainDB

class App : Application() {
    val database by lazy { MainDB.createDatabase(this) }
}
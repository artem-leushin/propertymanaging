package com.panda.materialproperty

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.huma.room_for_asset.RoomAsset
import com.panda.materialproperty.data.EnterprisesDatabase
import java.io.File


/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */

const val DB_NAME = "enterprises.db"

class App : Application() {

    var database: EnterprisesDatabase? = null
        private set(value) {
            field = value
        }

    override fun onCreate() {
        super.onCreate()

//        database = RoomAsset.databaseBuilder(
//            this,
//            EnterprisesDatabase::class.java,
//            "enterprises.db",
//            getExternalFilesDir(null).absolutePath
//        )
//            .build()
    }
}
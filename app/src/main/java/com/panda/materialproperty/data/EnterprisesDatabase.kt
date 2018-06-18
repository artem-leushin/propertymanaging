package com.panda.materialproperty.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.panda.materialproperty.data.entity.EnterpriseDB
import com.panda.materialproperty.data.repository.EnterprisesDao

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */

@Database(entities = [EnterpriseDB::class], version = 2)
abstract class EnterprisesDatabase : RoomDatabase() {

    abstract fun enterprisesDao(): EnterprisesDao

}
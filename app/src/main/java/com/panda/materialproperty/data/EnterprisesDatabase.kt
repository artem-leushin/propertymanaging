package com.panda.materialproperty.data

import android.content.Context
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */

const val DB_NAME = "enterprises.db"
const val DB_VERSION = 1

class EnterprisesDatabase(context: Context) :
    SQLiteAssetHelper(context, DB_NAME, null, DB_VERSION) {
}
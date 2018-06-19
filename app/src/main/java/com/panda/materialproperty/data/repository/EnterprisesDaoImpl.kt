package com.panda.materialproperty.data.repository

import android.database.Cursor
import com.panda.materialproperty.data.EnterprisesDatabase
import com.panda.materialproperty.data.EnterprisesDatabase_Impl
import com.panda.materialproperty.data.entity.EnterpriseDB
import io.reactivex.Flowable
import android.database.sqlite.SQLiteQueryBuilder
import android.database.sqlite.SQLiteDatabase



/**
 * Created by A.Olkinitskaya on 19.06.2018.
 */

class EnterprisesDaoImpl(
    private val databaseProvider: EnterprisesDatabase
) : EnterprisesDao {

    override fun getAllEnterprises(): Flowable<List<EnterpriseDB>> {
        val query = "SELECT * FROM Nedvizh"

        val db = databaseProvider.readableDatabase
        val qb = SQLiteQueryBuilder()
    }

    override fun getEnterprisesForLocation(
        address: String,
        columnName: String
    ): Flowable<List<EnterpriseDB>> {
        TODO("not implemented")
    }

    override fun getEnterprisesForLocationExact(address: String): Flowable<List<EnterpriseDB>> {
        TODO("not implemented")
    }

    override fun getEnterprisesForLocationMatch(address: String): Flowable<List<EnterpriseDB>> {
        TODO("not implemented")
    }
}

fun getEmployees(): Cursor {

    val db = getReadableDatabase()
    val qb = SQLiteQueryBuilder()

    val sqlSelect = arrayOf("0 _id", "FirstName", "LastName")
    val sqlTables = "Employees"

    qb.tables = sqlTables
    val c = qb.query(db, sqlSelect, null, null, null, null, null)

    c.moveToFirst()
    return c

}
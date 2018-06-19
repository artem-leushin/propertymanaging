package com.panda.materialproperty.data.repository

import androidx.core.database.getInt
import com.panda.materialproperty.data.DB_NAME
import com.panda.materialproperty.data.EnterprisesDatabase
import com.panda.materialproperty.data.TABLE_NAME
import com.panda.materialproperty.data.columns
import com.panda.materialproperty.data.entity.EnterpriseDB
import io.reactivex.Observable


/**
 * Created by A.Olkinitskaya on 19.06.2018.
 */

class EnterprisesDaoImpl(
    private val dbProvider: EnterprisesDatabase
) : EnterprisesDao {

    override fun getAllEnterprises(): Observable<List<EnterpriseDB>> =
        Observable.never()


    override fun getEnterprisesForLocation(
        address: String,
        columnName: String
    ): Observable<List<EnterpriseDB>> =
        Observable.fromCallable {
            val query = "SELECT * FROM $TABLE_NAME WHERE Адрес LIKE '%$address%'"
            val cursor = dbProvider.readableDatabase.rawQuery(query, null)

            val items: MutableList<EnterpriseDB> = mutableListOf()
            cursor.apply {
                while (moveToNext()) {

                    var index: Int = getColumnIndexOrThrow("№ п/п")
                    val id = getInt(index)

                    index = getColumnIndexOrThrow("Наименование объекта учета")
                    val name = getString(index)

                    index = getColumnIndexOrThrow("Тип объекта недвижимости")
                    val type = getString(index)

                    index = getColumnIndexOrThrow("Номер регистрации иного вещного права\n")
                    val number = getString(index)

                    items += EnterpriseDB(
                        id = id,
                        objectAccountingName = name,
                        propertyObjectType = type,
                        ownershipRegistrationNumberOther = number
                    )
                }
            }.close()

            items
        }

    override fun getEnterprisesForLocationExact(address: String): Observable<List<EnterpriseDB>> {
        TODO("not implemented")
    }

    override fun getEnterprisesForLocationMatch(address: String): Observable<List<EnterpriseDB>> {
        TODO("not implemented")
    }
}


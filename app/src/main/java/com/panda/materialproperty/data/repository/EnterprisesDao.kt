package com.panda.materialproperty.data.repository

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.panda.materialproperty.data.entity.EnterpriseDB
import io.reactivex.Flowable

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */

@Dao
interface EnterprisesDao {

    @Query("SELECT * FROM Nedvizh")
    fun getAllEnterprises(): Flowable<List<EnterpriseDB>>

    @Query("SELECT * FROM Nedvizh WHERE :columnName == :address")
    fun getEnterprisesForLocation(address: String, columnName: String): Flowable<List<EnterpriseDB>>

    @Query("SELECT * FROM Nedvizh WHERE `Адрес` == (:address)")
    fun getEnterprisesForLocationExact(address: String): Flowable<List<EnterpriseDB>>

    @Query("SELECT * FROM Nedvizh WHERE `Адрес` IN (:address)")
    fun getEnterprisesForLocationMatch(address: String): Flowable<List<EnterpriseDB>>

//    @Query("SELECT * FROM Nedvizh WHERE `Дата РФ` IS NOT NULL AND `Дата РФ` != ''")
//    fun getEnterprisesWithDateRf(): Flowable<List<EnterpriseDB>>
}
package com.panda.materialproperty.data.repository

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.panda.materialproperty.data.entity.EnterpriseDB
import io.reactivex.Flowable

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */

interface EnterprisesDao {

    fun getAllEnterprises(): Flowable<List<EnterpriseDB>>

    fun getEnterprisesForLocation(address: String, columnName: String): Flowable<List<EnterpriseDB>>

    fun getEnterprisesForLocationExact(address: String): Flowable<List<EnterpriseDB>>

    fun getEnterprisesForLocationMatch(address: String): Flowable<List<EnterpriseDB>>

}
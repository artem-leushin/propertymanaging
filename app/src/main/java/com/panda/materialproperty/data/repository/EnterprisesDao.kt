package com.panda.materialproperty.data.repository

import com.panda.materialproperty.data.entity.EnterpriseDB
import io.reactivex.Observable

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */

interface EnterprisesDao {

    fun getAllEnterprises(): Observable<List<EnterpriseDB>>

    fun getEnterprisesForLocation(address: String, columnName: String): Observable<List<EnterpriseDB>>

    fun getEnterprisesForLocationExact(address: String): Observable<List<EnterpriseDB>>

    fun getEnterprisesForLocationMatch(address: String): Observable<List<EnterpriseDB>>

}
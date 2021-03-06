package com.panda.materialproperty.domain.repository

import com.panda.materialproperty.domain.entity.Enterprise
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */
interface EnterprisesRepository {

    fun getAllEnterprises(): Observable<List<Enterprise>>

    fun getEnterprisesForLocation(where: String): Observable<List<Enterprise>>
}
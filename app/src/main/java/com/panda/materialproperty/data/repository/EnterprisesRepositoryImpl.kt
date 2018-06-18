package com.panda.materialproperty.data.repository

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.panda.materialproperty.domain.entity.Enterprise
import com.panda.materialproperty.domain.repository.EnterprisesRepository
import io.reactivex.Observable

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */

class EnterprisesRepositoryImpl(

) : EnterprisesRepository {

    override fun getAllEnterprises(): Observable<List<Enterprise>> {
        TODO("not implemented")
    }

    override fun getEnterprisesForLocation(where: String): Observable<List<Enterprise>> {
        TODO("not implemented")
    }
}
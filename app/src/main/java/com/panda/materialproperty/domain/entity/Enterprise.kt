package com.panda.materialproperty.domain.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */

data class Enterprise(

    val id: Int = Int.MIN_VALUE,

    val cardStatus: String = "",
    val objectAccountingName: String = "",

    val rnfi: String = "",
    val dateRnfi: String = "",

    val totalSquare: Int = Int.MIN_VALUE,
    val length: Int = Int.MIN_VALUE,

    val ownershipRegistrationNumberRf: String = "",
    val dateOwnershipRf: String = "",

    val ownershipRegistrationNumberOther: String = "",
    val dateOwnershipOther: String = "",

    val cadasrtalNumber: String = "",
    val dateCadastral: String = "",

    val address: String = "",
    val propertyObjectType: String = "",
    val objectPurpose: String = "",
    val inventoryNumber: Int = Int.MIN_VALUE,
    val implementationYear: Int = Int.MIN_VALUE,
    val initialPriceRub: Int = Int.MIN_VALUE,
    val remainingPriceRub: Int = Int.MIN_VALUE,
    val systemNumber: Int = Int.MIN_VALUE,
    val requestNumber: Int = Int.MIN_VALUE,
    val order: String = "",

    val commentary: String = ""
)
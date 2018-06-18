package com.panda.materialproperty.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */

@Entity(tableName = "Nedvizh")
data class EnterpriseDB(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "№ п/п", typeAffinity = ColumnInfo.INTEGER)
    val id: Int = Int.MIN_VALUE,

    @ColumnInfo(name = "Статус карты", typeAffinity = ColumnInfo.TEXT)
    val cardStatus: String,

    @ColumnInfo(name = "Наименование объекта учета", typeAffinity = ColumnInfo.TEXT)
    val objectAccountingName: String,

    @ColumnInfo(name = "РНФИ", typeAffinity = ColumnInfo.TEXT)
    val rnfi: String,

    @ColumnInfo(name = "Дата РНФИ", typeAffinity = ColumnInfo.TEXT)
    val dateRnfi: String,

    @ColumnInfo(name = "Общая площадь, км", typeAffinity = ColumnInfo.INTEGER)
    val totalSquare: Int? = null,

    @ColumnInfo(name = "Протяженность, км", typeAffinity = ColumnInfo.INTEGER)
    val length: Int? = null,

    @ColumnInfo(name = "Номер регистрации права собственности РФ", typeAffinity = ColumnInfo.TEXT)
    val ownershipRegistrationNumberRf: String? = null,

    @ColumnInfo(name = "Дата РФ", typeAffinity = ColumnInfo.TEXT)
    val dateOwnershipRf: String? = null,

    @ColumnInfo(name = "Номер регистрации иного вещного права", typeAffinity = ColumnInfo.TEXT)
    val ownershipRegistrationNumberOther: String? = null,

    @ColumnInfo(name = "Дата (иное вещное право)", typeAffinity = ColumnInfo.TEXT)
    val dateOwnershipOther: String? = null,

    @ColumnInfo(name = "Кадастровый номер", typeAffinity = ColumnInfo.TEXT)
    val cadasrtalNumber: String? = null,

    @ColumnInfo(name = "Дата (кадастровый)", typeAffinity = ColumnInfo.TEXT)
    val dateCadastral: String? = null,

    @ColumnInfo(name = "Адрес", typeAffinity = ColumnInfo.TEXT)
    val address: String,

    @ColumnInfo(name = "Тип объекта недвижимости", typeAffinity = ColumnInfo.TEXT)
    val propertyObjectType: String,

    @ColumnInfo(name = "Назначение объекта", typeAffinity = ColumnInfo.TEXT)
    val objectPurpose: String,

    @ColumnInfo(name = "Инвентарный номер", typeAffinity = ColumnInfo.INTEGER)
    val inventoryNumber: Int,

    @ColumnInfo(name = "Год ввода в эксплуатацию", typeAffinity = ColumnInfo.INTEGER)
    val implementationYear: Int,

    @ColumnInfo(name = "Первоначальная стоимость, руб", typeAffinity = ColumnInfo.INTEGER)
    val initialPriceRub: Int,

    @ColumnInfo(name = "Остаточная стоимость, руб", typeAffinity = ColumnInfo.INTEGER)
    val remainingPriceRub: Int,

    @ColumnInfo(name = "Системный №", typeAffinity = ColumnInfo.INTEGER)
    val systemNumber: Int,

    @ColumnInfo(name = "Запрос №", typeAffinity = ColumnInfo.INTEGER)
    val requestNumber: Int,

    @ColumnInfo(name = "Распоряжение", typeAffinity = ColumnInfo.TEXT)
    val order: String,

    @ColumnInfo(name = "Примечание", typeAffinity = ColumnInfo.TEXT)
    val commentary: String? = null

)
package com.panda.materialproperty.data

import android.content.Context
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

/**
 * Created by A.Olkinitskaya on 17.06.2018.
 */

const val DB_NAME = "enterprises.db"
const val TABLE_NAME = "Nedvizh"
const val DB_VERSION = 1

class EnterprisesDatabase(context: Context) :
    SQLiteAssetHelper(context, DB_NAME, null, DB_VERSION) {
}

val columns: Array<String> = arrayOf(
    "№ п/п",
    "Статус карты",
    "Наименование объекта учета",
    "РНФИ",
    "Дата РНФИ",
    "Общая площадь, км",
    "Протяженность, км",
    "Номер регистрации права собственности РФ",
    "Дата РФ",
    "Номер регистрации иного вещного права\n",
    "Дата (иное вещное право)\n",
    "Кадастровый номер",
    "Дата (кадастровый)\n",
    "Адрес",
    "Тип объекта недвижимости",
    "Назначение объекта",
    "Инвентарный номер",
    "Год ввода в эксплуатацию",
    "Первоначальная стоимость, руб",
    "Остаточная стоимость, руб",
    "Системный №",
    "Запрос №",
    "Распоряжение",
    "Примечание\n"
)
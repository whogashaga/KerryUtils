package com.kerry.kerryutils

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

private inline fun <T> SharedPreferences.delegate(
    defaultValue: T,
    key: String,
    crossinline getter: SharedPreferences.(String, T) -> T,
    crossinline setter: SharedPreferences.Editor.(String, T) -> SharedPreferences.Editor
): ReadWriteProperty<Any, T> {
    return object : ReadWriteProperty<Any, T> {
        override fun getValue(thisRef: Any, property: KProperty<*>) =
            getter(key, defaultValue)

        override fun setValue(thisRef: Any, property: KProperty<*>, value: T) =
            edit().setter(key, value).apply()
    }
}

fun SharedPreferences.int(def: Int = 0, key: String) =
    delegate(def, key, SharedPreferences::getInt, SharedPreferences.Editor::putInt)

fun SharedPreferences.long(def: Long = 0, key: String) =
    delegate(def, key, SharedPreferences::getLong, SharedPreferences.Editor::putLong)

fun SharedPreferences.string(def: String = "", key: String) =
    delegate(def, key, SharedPreferences::getString, SharedPreferences.Editor::putString)
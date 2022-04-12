package com.example.hammersystems.library.coreimpl.locale

import android.content.Context
import android.content.SharedPreferences
import com.example.hammersystems.feature.menu.domain.model.CategoryEntity
import com.example.hammersystems.feature.menu.domain.model.ProductEntity
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

interface PreferenceStorage {

    var lastCategories: List<CategoryEntity>
    var lastProducts: List<ProductEntity>
}

class SharedPreferencesStorage @Inject constructor(@ApplicationContext val context: Context): PreferenceStorage{

    private val prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    override var lastCategories by ListCategoriesPreference<CategoryEntity>(prefs, PREF_LAST_CATEGORIES)

    override var lastProducts by ListProductsPreference<ProductEntity>(prefs, PREF_LAST_PRODUCTS)

    companion object{

        const val PREF_NAME = "PREF_NAME"
        const val PREF_LAST_PRODUCTS = "PREF_LAST_PRODUCTS"
        const val PREF_LAST_CATEGORIES = "PREF_LAST_CATEGORIES"
    }
}

class ListCategoriesPreference<T>(
    private val pref: SharedPreferences,
    private val key: String
): ReadWriteProperty<Any, List<T>> {

    override fun getValue(thisRef: Any, property: KProperty<*>): List<T> {
        val listType = object : TypeToken<ArrayList<CategoryEntity?>?>() {}.type
        return Gson().fromJson(pref.getString(key, ""), listType)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: List<T>) {
        pref.edit().putString(key, Gson().toJson(value)).apply()
    }
}

class ListProductsPreference<T>(
    private val pref: SharedPreferences,
    private val key: String
): ReadWriteProperty<Any, List<T>> {

    override fun getValue(thisRef: Any, property: KProperty<*>): List<T> {
        val listType = object : TypeToken<ArrayList<ProductEntity?>?>() {}.type
        return Gson().fromJson(pref.getString(key, ""), listType)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: List<T>) {
        pref.edit().putString(key, Gson().toJson(value)).apply()
    }
}
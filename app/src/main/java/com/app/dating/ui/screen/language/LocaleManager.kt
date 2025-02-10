package com.app.dating.ui.screen.language

import android.content.Context
import android.content.res.Configuration
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

class LocaleManager @Inject constructor(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    fun setLocale(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)

        context.resources.updateConfiguration(config, context.resources.displayMetrics)

        // Save selected language
        sharedPreferences.edit().putString("app_lang", language).apply()
    }

    fun getLocale(): String {
        return sharedPreferences.getString("app_lang", Locale.getDefault().language) ?: "en"
    }
}

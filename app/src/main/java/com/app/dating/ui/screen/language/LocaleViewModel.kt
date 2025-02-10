package com.app.dating.ui.screen.language

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LocaleViewModel @Inject constructor(private val localeManager: LocaleManager) : ViewModel() {
    private val _currentLocale = MutableStateFlow(localeManager.getLocale())
    val currentLocale: StateFlow<String> = _currentLocale.asStateFlow()

    fun changeLanguage(language: String) {
        localeManager.setLocale(language)
        _currentLocale.value = language
    }
}

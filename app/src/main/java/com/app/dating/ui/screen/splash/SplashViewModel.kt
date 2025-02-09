package com.app.dating.ui.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.dating.database.datastore.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val dataStoreManager: DataStoreManager):ViewModel() {
    val walkThroughState: StateFlow<Boolean> = dataStoreManager.walkThroughFlow.stateIn(
        viewModelScope, SharingStarted.Lazily, false
    )

}
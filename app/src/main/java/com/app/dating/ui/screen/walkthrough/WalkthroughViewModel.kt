package com.app.dating.ui.screen.walkthrough

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.dating.database.datastore.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WalkthroughViewModel @Inject constructor(private val dataStoreManager: DataStoreManager):ViewModel(){
    // Read User Name (StateFlow)
    val userNameState: StateFlow<String> = dataStoreManager.userNameFlow.stateIn(
        viewModelScope, SharingStarted.Lazily, "Guest"
    )

    // Save Dark Mode
    fun setWalkThrough(isEnabled: Boolean) {
        viewModelScope.launch {
            dataStoreManager.saveWalkThrough(isEnabled)
        }
    }

    // Save User Name
    fun updateUserName(name: String) {
        viewModelScope.launch {
            dataStoreManager.saveUserName(name)
        }
    }
}
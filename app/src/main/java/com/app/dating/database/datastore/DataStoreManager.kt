package com.app.dating.database.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

// Define DataStore Extension
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_prefs")

@Singleton
class DataStoreManager @Inject constructor(@ApplicationContext private val context: Context) {

    companion object {
        private val IS_WALKTHROUGH_DONE = booleanPreferencesKey("dark_mode")
        private val USER_NAME_KEY = stringPreferencesKey("user_name")
    }

    // Save Dark Mode
    suspend fun saveWalkThrough(isEnabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_WALKTHROUGH_DONE] = isEnabled
        }
    }

    // Read Dark Mode as Flow
    val walkThroughFlow: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[IS_WALKTHROUGH_DONE] ?: false
    }

    // Save User Name
    suspend fun saveUserName(name: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME_KEY] = name
        }
    }

    // Read User Name as Flow
    val userNameFlow: Flow<String> = context.dataStore.data.map { preferences ->
        preferences[USER_NAME_KEY] ?: "Guest"
    }
}

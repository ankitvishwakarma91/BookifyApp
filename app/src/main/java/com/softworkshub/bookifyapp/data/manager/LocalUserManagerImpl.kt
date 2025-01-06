package com.softworkshub.bookifyapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.softworkshub.bookifyapp.domain.manager.LocalUserManager
import com.softworkshub.bookifyapp.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


private val Context.dataStore by preferencesDataStore("USER_SETTINGS")

class LocalUserManagerImpl (
    private val context: Context,
): LocalUserManager {

    private val APP_ENTRY_KEY = booleanPreferencesKey("app_entry")

    override suspend fun saveEntry() {
        context.dataStore.edit { settings ->
            settings[APP_ENTRY_KEY] = true
        }
    }
    override fun readEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[APP_ENTRY_KEY] ?: false
        }
    }

}
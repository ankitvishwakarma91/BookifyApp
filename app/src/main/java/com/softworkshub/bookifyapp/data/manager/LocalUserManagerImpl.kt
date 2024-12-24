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

class LocalUserManagerImpl (
    private val context: Context,
): LocalUserManager {

    private val readOnlyProperty = preferencesDataStore(name = "USER_SETTINGS")
    private val Context.dataStore : DataStore<Preferences> by readOnlyProperty

    override suspend fun saveEntry() {
        context.dataStore.edit { settings ->
            settings[PreferencesKey.APP_ENTRY] = true
        }
    }

    override fun readEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKey.APP_ENTRY] ?: false
        }
    }

    private object PreferencesKey{
        val APP_ENTRY = booleanPreferencesKey(Constants.APP_ENTRY)
    }
}
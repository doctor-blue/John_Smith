package com.example.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserManager(context: Context) {
    private val dataStore: DataStore<Preferences> = context.createDataStore(
        name = "settings"
    )

    companion object {
        val USER_NAME = preferencesKey<String>("user_name")
        val PASSWORD = preferencesKey<String>("password")

    }

    val userNameFlow: Flow<String> = dataStore.data
        .map { currentPreferences ->
            // Unlike Proto DataStore, there's no type safety here.
            currentPreferences[USER_NAME] ?: ""
        }
    val passwordFlow: Flow<String> = dataStore.data
        .map { currentPreferences ->
            // Unlike Proto DataStore, there's no type safety here.
            currentPreferences[PASSWORD] ?: ""
        }

    suspend fun storeUser(userName: String, password: String) {
        dataStore.edit { settings ->
            settings[USER_NAME] = userName
            settings[PASSWORD] = password
        }
    }
}
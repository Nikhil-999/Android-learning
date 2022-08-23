package com.example.preferences_datastore.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private const val LAYOUT_PREFERENCES_NAME = "layout_preferences"

private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(
    name = LAYOUT_PREFERENCES_NAME
)

class SettingsDataStore(context: Context) {
    companion object{
        val USER_NAME = stringPreferencesKey("USER_NAME")
        val USER_AGE = stringPreferencesKey("USER_AGE")
    }

    // Below the writing to the datastore of type preferences.
    suspend fun saveLayoutToPreferencesStore(user_name: String, user_age: String , context: Context) {
        context.dataStore.edit{ preferences ->
            preferences[USER_NAME] = user_name
            preferences[USER_AGE] = user_age
        }
    }

    //below is reading the stored data both val variables return the data.
    val preferenceFlow: Flow<String> = context.dataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            preferences[USER_NAME] ?: "No Name inserted"
        }

    val preferenceFlow2: Flow<String> = context.dataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            preferences[USER_AGE] ?: "0"
        }

}
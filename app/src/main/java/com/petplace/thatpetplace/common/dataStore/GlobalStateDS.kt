package com.petplace.thatpetplace.common.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map


val Context.GlobalStateDS : DataStore<Preferences> by preferencesDataStore("global_state")

data class GlobalState(
    val isLoggedIn:Boolean,
    val welcomeScreenCompleted:Boolean,
    val userID: String,
    val firstName: String,
)

class GlobalStateDS (context: Context){
    private val globalStateDS = context.GlobalStateDS

    private object PreferenceKeys{
        val IS_LOGIN_COMPLETED = booleanPreferencesKey("logged_in")
        val IS_WELCOME_COMPLETED = booleanPreferencesKey("welcome")
        val USERID = stringPreferencesKey("userid")
        val FIRST_NAME = stringPreferencesKey("firstname")
    }
    val stateStatusFlow = globalStateDS.data.catch{ exp->
        if(exp is IOException){
            emit(emptyPreferences())
        }
        else {
            throw exp
        }
    }.map {
        val isLoggedIn = it[PreferenceKeys.IS_LOGIN_COMPLETED] ?:false
        val isWelcomeCompleted = it[PreferenceKeys.IS_WELCOME_COMPLETED]?:false
        val userId= it[PreferenceKeys.USERID]?: ""
        val firstName = it[PreferenceKeys.FIRST_NAME]?: ""
        GlobalState(isLoggedIn,isWelcomeCompleted, userId, firstName)
    }

    suspend fun updateLoginStatus(isLoggedIn :Boolean){
        globalStateDS.edit {
            it[PreferenceKeys.IS_LOGIN_COMPLETED] = isLoggedIn
        }
    }
    suspend fun updateWelcomeStatus(welcomeCompleted :Boolean){
        globalStateDS.edit {
            it[PreferenceKeys.IS_WELCOME_COMPLETED] = welcomeCompleted
        }
    }
    suspend fun updateUserId(userID: String){
        globalStateDS.edit {
            it[PreferenceKeys.USERID] = userID
        }
    }
    suspend fun updateFirstName(firstName: String){
        globalStateDS.edit {
            it[PreferenceKeys.FIRST_NAME] = firstName
        }
    }


}
package com.petplace.thatpetplace.auth.presentation.signup




import android.content.Context

import android.util.Log

import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialCancellationException

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.petplace.thatpetplace.BuildConfig.WEB_CLIENT_ID

import com.petplace.thatpetplace.common.utils.Resource
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collectLatest

import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.security.MessageDigest
import java.util.UUID

class SigUpViewModel ( private val firebaseAuth: FirebaseAuth):ViewModel(){
     fun signInWithGoogle(context: Context) {
         viewModelScope.launch {
             googleSignIn(context,firebaseAuth).collectLatest { result ->
                 when (result) {
                     is Resource.Loading -> {
                         Log.e("sdoivnweu", "done")
                     }

                     is Resource.Error -> {
                         Log.e("sdoivnweu", result.message.toString())

                     }

                     is Resource.Success -> {

                         Log.e("sdoivnweu", "fuck yeahhhhhhhhh")

                     }
                 }
             }


         }
     }
    }



suspend fun googleSignIn(context: Context,firebaseAuth: FirebaseAuth): Flow<Resource<AuthResult>> {
    return callbackFlow {

        try {
            // Initialize Credential Manager
            val credentialManager: CredentialManager = CredentialManager.create(context)

            // Generate a nonce (a random number used once)
            val ranNonce: String = UUID.randomUUID().toString()
            val bytes: ByteArray = ranNonce.toByteArray()
            val md: MessageDigest = MessageDigest.getInstance("SHA-256")
            val digest: ByteArray = md.digest(bytes)
            val hashedNonce: String = digest.fold("") { str, it -> str + "%02x".format(it) }

            // Set up Google ID option
            val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(WEB_CLIENT_ID)
                .setNonce(hashedNonce)
                .build()

            // Request credentials
            val request: GetCredentialRequest = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            // Get the credential result
            val result = credentialManager.getCredential(context, request)
            val credential = result.credential

            // Check if the received credential is a valid Google ID Token
            if (credential is CustomCredential && credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                val googleIdTokenCredential =
                    GoogleIdTokenCredential.createFrom(credential.data)
                val authCredential =
                    GoogleAuthProvider.getCredential(googleIdTokenCredential.idToken, null)
                val authResult = firebaseAuth.signInWithCredential(authCredential).await()
                trySend(Resource.Success(authResult))
            } else {
                throw RuntimeException("Received an invalid credential type")
            }
        } catch (e: GetCredentialCancellationException) {
            trySend(Resource.Error("Sign-in was canceled. Please try again."))

        } catch (e: Exception) {
            trySend(Resource.Error(e.message.toString()))
        }
        awaitClose { }
    }
}


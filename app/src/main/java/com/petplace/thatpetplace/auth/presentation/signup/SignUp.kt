//package com.petplace.thatpetplace.auth.presentation.signup
//
//import android.annotation.SuppressLint
//import android.content.ContentValues.TAG
//import android.util.Log
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.KeyboardArrowLeft
//import androidx.compose.material3.Divider
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.credentials.CredentialManager
//import androidx.credentials.CustomCredential
//import androidx.credentials.GetCredentialRequest
//import androidx.credentials.GetCredentialRequest.Builder
//import androidx.credentials.GetCredentialResponse
//import androidx.credentials.PasswordCredential
//import androidx.credentials.PublicKeyCredential
//import androidx.credentials.exceptions.GetCredentialException
//import androidx.navigation.NavHostController
//import com.google.android.libraries.identity.googleid.GetGoogleIdOption
//import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
//import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
//import com.google.api.client.http.javanet.NetHttpTransport
//import com.google.api.client.json.gson.GsonFactory
//import com.petplace.thatpetplace.R
//import com.petplace.thatpetplace.auth.presentation.common.components.CircleLogo
//import com.petplace.thatpetplace.auth.presentation.common.components.CustomButton
//import com.petplace.thatpetplace.common.Routes
//import com.petplace.thatpetplace.ui.theme.rozha
//import kotlinx.coroutines.launch
//import java.security.MessageDigest
//import java.util.UUID
//
////GoogleToken
//
//
//
//
//@Composable
//fun SignUp(
//    navHostController: NavHostController
//) {
//
//
//    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
//        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
//            IconButton(
//                onClick = { navHostController.navigate(Routes.AuthRoutes.LOGIN_SCREEN) },
//            ) {
//
//                Icon(
//                    imageVector = Icons.Default.KeyboardArrowLeft,
//                    contentDescription = "Back",
//                    modifier = Modifier.size(35.dp),
//                    tint = Color.White
//                )
//            }
//            Text(
//                text = "Login", fontSize = 16.sp,
//                letterSpacing = 2.sp,
//                fontWeight = FontWeight(600),
//                color = Color.White,
//            )
//
//        }
//    }) { paddingValues ->
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(
//                    brush = Brush.verticalGradient(
//                        listOf(
//                            Color(0xFFFDA8A5),
//                            Color(0xFFFFCB9C),
//                        )
//                    )
//                )
//                .padding(top = paddingValues.calculateTopPadding())
//                .padding(horizontal = 16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "That Pet Place",
//                fontSize = 40.sp,
//                fontFamily = rozha,
//                color = Color.White,
//                modifier = Modifier.padding(bottom = 15.dp)
//            )
//            CircleLogo()
//            Spacer(modifier = Modifier.height(20.dp))
//            CustomButton(label = "Register",
//                onClick = { navHostController.navigate(Routes.AuthRoutes.SIGNUP_DETAILS_SCREEN) })
//            Spacer(modifier = Modifier.height(15.dp))
//            Box(
//                modifier = Modifier
//                    .height(20.dp)
//                    .width(360.dp), Alignment.Center
//            ) {
//                Divider(color = Color(0x57302D2D), modifier = Modifier.width(370.dp))
//                Text(
//                    text = "or use",
//                    modifier = Modifier
//                        .width(60.dp)
//                        .background(Color.White),
//                    textAlign = TextAlign.Center,
//                    fontSize = 13.sp,
//                    color = Color(
//                        0x881F1E1E
//                    )
//                )
//            }
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp)
//                    .height(50.dp),
//                horizontalArrangement = Arrangement.Absolute.Center
//            ) {
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.google_logo),
//                        contentDescription = "Google",
//                        Modifier.fillMaxSize(),
//                        tint = Color.Unspecified
//                    )
//                }
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.fb),
//                        contentDescription = "Google",
//                        Modifier.fillMaxSize(),
//                        tint = Color.Unspecified
//                    )
//                }
//
//            }
//        }
//    }
//}
//@SuppressLint("CoroutineCreationDuringComposition")
//@Composable
//fun GoogleSignin() {
//    val context = LocalContext.current
//    val coroutineScope = rememberCoroutineScope()
//    val rawNonce = UUID.randomUUID().toString()
//    val bytes = rawNonce.toByteArray()
//    val md = MessageDigest.getInstance("SHA-256")
//    val digest = md.digest(bytes)
//    val hashedNonce = digest.fold("") { str, it -> str + "%02x".format(it) }
//    val credentialManager = CredentialManager.create(context)
//
//    val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
//        .setFilterByAuthorizedAccounts(true)
//        .setServerClientId(R.string.client_id.toString())
//        .setAutoSelectEnabled(true)
//        .setNonce(hashedNonce)
//        .build()
//    val request: GetCredentialRequest = Builder()
//        .addCredentialOption(googleIdOption)
//        .build()
//
//    coroutineScope.launch {
//        try {
//            val result = credentialManager.getCredential(
//                request = request,
//                context = context,
//            )
//            handleSignIn(result)
//        } catch (e: GetCredentialException) {
//           // handleFailure(e)
//        }
//    }
//
//}
//
//fun handleSignIn(result: GetCredentialResponse) {
//    // Handle the successfully returned credential.
//    val credential = result.credential
//
//    when (credential) {
//
//        // Passkey credential
//        is PublicKeyCredential -> {
//            // Share responseJson such as a GetCredentialResponse on your server to
//            // validate and authenticate
//            val responseJson = credential.authenticationResponseJson
//        }
//
//        // Password credential
//        is PasswordCredential -> {
//            // Send ID and password to your server to validate and authenticate.
//            val username = credential.id
//            val password = credential.password
//        }
//
//        // GoogleIdToken credential
//        is CustomCredential -> {
//            if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
//                try {
//                    // Use googleIdTokenCredential and extract the ID to validate and
//                    // authenticate on your server.
//                    val googleIdTokenCredential = GoogleIdTokenCredential
//                        .createFrom(credential.data)
//                    // You can use the members of googleIdTokenCredential directly for UX
//                    // purposes, but don't use them to store or control access to user
//                    // data. For that you first need to validate the token:
//                    // pass googleIdTokenCredential.getIdToken() to the backend server.
////                    GoogleIdTokenVerifier verifier = ... // see validation instructions
////                    GoogleIdToken idToken = verifier.verify(idTokenString);
//                    // To get a stable account identifier (e.g. for storing user data),
//                    // use the subject ID:
////                    idToken.getPayload().getSubject()
//                } catch (e: GoogleIdTokenParsingException) {
//                    Log.e(TAG, "Received an invalid google id token response", e)
//                }
//            } else {
//                // Catch any unrecognized custom credential type here.
//                Log.e(TAG, "Unexpected type of credential")
//            }
//        }
//
//        else -> {
//            // Catch any unrecognized credential type here.
//            Log.e(TAG, "Unexpected type of credential")
//        }
//    }
//}
//
//fun GoogleVerifier(){
//
//    val transport = NetHttpTransport()
//    val jsonFactory = GsonFactory.getDefaultInstance()
//    val CLIENT_ID = R.string.client_id.toString() // Replace with your actual client ID
//
//    val verifier = GoogleIdTokenVerifier.Builder(transport, jsonFactory)
//        .setAudience(listOf(CLIENT_ID))
//        .build()
//
//// (Receive idTokenString by HTTPS POST)
//
//    val idToken: GoogleIdToken? = verifier.verify(
////        idTokenString
//        "asd"
//    )
//
//    if (idToken != null) {
//        val payload = idToken.payload
//
//        // Print user identifier
//        val userId = payload.subject
//        println("User ID: $userId")
//
//        // Get profile information from payload
//        val email = payload.email
//        val emailVerified = payload.emailVerified
//        val name = payload["name"] as? String
//        val pictureUrl = payload["picture"] as? String
//        val locale = payload["locale"] as? String
//        val familyName = payload["family_name"] as? String
//        val givenName = payload["given_name"] as? String
//
//        // Use or store profile information
//        // ...
//
//    } else {
//        println("Invalid ID token.")
//    }
//}
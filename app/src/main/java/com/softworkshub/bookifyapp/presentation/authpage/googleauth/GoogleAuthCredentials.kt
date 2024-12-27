package com.softworkshub.bookifyapp.presentation.authpage.googleauth
//
//import android.content.Context
//import android.credentials.GetCredentialException
//import android.os.Build
//import android.util.Log
//import androidx.annotation.RequiresApi
//import androidx.credentials.CredentialManager
//import androidx.credentials.GetCredentialRequest
//import androidx.credentials.exceptions.NoCredentialException
////import com.google.android.libraries.identity.googleid.
//import com.softworkshub.bookifyapp.R
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//
//@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
//suspend fun googleAuthCredentials(
//    context: Context,
//    onSignSuccess: () -> Unit,
//    onSignFailure: (String) -> Unit
//) {
//    try {
//        // Build the sign-in options
//        val signInWithGoogleOption = GetSignInWithGoogleOption
//            .Builder(serverClientId = context.getString(R.string.web_client))
//            .build()
//
//        // Create the credential request
//        val request = GetCredentialRequest
//            .Builder()
//            .addCredentialOption(signInWithGoogleOption)
//            .build()
//
//        // Get the CredentialManager instance
//        val credentialManager = CredentialManager.create(context)
//
//        // Perform the sign-in request
//        val result = withContext(Dispatchers.IO) {
//            credentialManager.getCredential(context, request)
//        }
//
//        // If successful, invoke the success callback
//        onSignSuccess()
//    } catch (e: NoCredentialException) {
//        Log.e("GoogleSignIn", "No accounts available for sign-in", e)
//        onSignFailure("No accounts available")
//    } catch (e: GetCredentialException) {
//        Log.e("GoogleSignIn", "Sign-in failed", e)
//        onSignFailure("Sign-in failed: ${e.message}")
//    } catch (e: Exception) {
//        Log.e("GoogleSignIn", "Unexpected error during sign-in", e)
//        onSignFailure("Unexpected error: ${e.message}")
//    }
//}

package com.softworkshub.bookifyapp.presentation.authpage.sign
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.softworkshub.bookifyapp.R
import com.softworkshub.bookifyapp.util.Dimens.MediumHeight
import com.softworkshub.bookifyapp.util.Dimens.MediumPadding

@Composable
fun SignUpScreen(
    navController: NavController,
    onSignUpSuccess : () -> Unit,
) {

    val auth = FirebaseAuth.getInstance()

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var isLoading by remember {
        mutableStateOf(false)
    }
    var errorMessage by remember {
        mutableStateOf<String?>(null)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = stringResource(id = R.string.sign_up_page),
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(MediumHeight))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            },
            placeholder = { Text(text = stringResource(id = R.string.enter_your_email))},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(MediumHeight))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            },
            placeholder = { Text(text = stringResource(id = R.string.enter_password))},
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(MediumHeight))

        Button(
            onClick = {

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        isLoading = false
                        if (task.isSuccessful) {
                            Log.d("SignUpScreen", "Signup successful!")
                            onSignUpSuccess() // Trigger navigation to NavGraph
                        } else {
                            Log.e("SignUpScreen", "Signup failed", task.exception)
                            errorMessage = task.exception?.localizedMessage ?: "Unknown error"
                        }
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.sign_up)
            )
        }

    }
}

@Preview
@Composable
fun SignUpScreenPreview(){

    val navController = rememberNavController()

    SignUpScreen(
        navController = navController,
        onSignUpSuccess = {}
    )
}
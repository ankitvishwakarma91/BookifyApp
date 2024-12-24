package com.softworkshub.bookifyapp.presentation.authpage.login

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
import androidx.compose.material3.TextButton
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
import com.softworkshub.bookifyapp.util.Dimens


@Composable
fun LoginScreen(
    navController :NavController,
    onLoginSuccess:() -> Unit,
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.MediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = stringResource(id = R.string.login_page),
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(Dimens.MediumHeight))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            },
            placeholder = { Text(text = stringResource(id = R.string.enter_your_email)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(Dimens.MediumHeight))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            },
            placeholder = { Text(text = stringResource(id = R.string.enter_password)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(Dimens.MediumHeight))

        Button(
            onClick = {
                      val auth = FirebaseAuth.getInstance()
                auth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener { success->
                        if (success.isSuccessful){
                            onLoginSuccess()
                        }else{
                            errorMessage = success.exception?.localizedMessage ?: "Login Failed"
                        }
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.login)
            )
        }

        TextButton(onClick = { navController.navigate("signup_screen") }) {
            Text("Don't have an account? Sign up here!")
        }
    }

}

@Preview
@Composable
fun LoginScreenPreview(){

    val navController = rememberNavController()

    LoginScreen(
        navController = navController,
        onLoginSuccess = {}
    )
}
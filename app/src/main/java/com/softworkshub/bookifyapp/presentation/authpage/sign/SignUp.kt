//package com.softworkshub.bookifyapp.presentation.authpage.sign
//import android.os.Build
//import android.widget.Toast
//import androidx.annotation.RequiresApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.colorResource
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import com.softworkshub.bookifyapp.R
//import com.softworkshub.bookifyapp.presentation.authpage.common.BorderButton
//import com.softworkshub.bookifyapp.presentation.authpage.common.ButtonSubmit
//import com.softworkshub.bookifyapp.presentation.authpage.googleauth.googleAuthCredentials
//import com.softworkshub.bookifyapp.presentation.navgigation.Screen
//
//import kotlinx.coroutines.launch
//
//
//@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
//@Composable
//fun SignUp(
//     navController: NavHostController
//) {
//
//    val context = LocalContext.current
//    val coroutineScope  = rememberCoroutineScope()
//
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(colorResource(id = R.color.brownBackground)) // Background color
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(top = 10.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Box(
//                modifier = Modifier
//                    .width(250.dp)
//                    .height(250.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                Image(
//                    modifier = Modifier
//                        .size(500.dp)
//                        .padding(top = 50.dp),
//                    painter = painterResource(id = R.drawable.logo),
//                    contentDescription = "Logo"
//                )
//            }
//
//            Spacer(modifier = Modifier.height(80.dp))
//
//            Text(
//                text = "Sign Up",
//                color = colorResource(id = R.color.black),
//                fontSize = 40.sp,
//                fontWeight = FontWeight.Bold,
//                fontStyle = FontStyle.Normal,
//            )
//
//            Text(
//                text = "It is easier to Sign Up now",
//                color = colorResource(id = R.color.black),
//                fontSize = 15.sp,
//                fontWeight = FontWeight.Normal,
//                fontStyle = FontStyle.Normal,
//            )
//
//            Spacer(modifier = Modifier.height(30.dp))
//
//            ButtonSubmit(
//                modifier = Modifier.padding(vertical = 10.dp),
//                text = "Continue With Facebook",
//                fontSize = 20.sp,
//                onClick = {},
//                shape = RoundedCornerShape(50.dp),
//                width = 300.dp
//            )
//
//            ButtonSubmit(
//                modifier = Modifier.padding(vertical = 10.dp),
//                image = painterResource(id = R.drawable.google),
//                text = "Continue With Google",
//                fontSize = 20.sp,
//                onClick = {
//                    coroutineScope.launch {
//                        googleAuthCredentials(
//                            context = context,
//                            onSignSuccess = {
//                                navController.navigate(Screen.HomeScreen.route) {
//                                    popUpTo(Screen.SignUp.route) { inclusive = true }
//                                }
//                                Toast.makeText(context, "Sign-in successful!", Toast.LENGTH_SHORT).show()
//                            },
//                            onSignFailure = { error ->
//                                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
//                            }
//                        )
//                    }
//                },
//                shape = RoundedCornerShape(50.dp),
//                width = 300.dp
//            )
//
//            BorderButton(
//                modifier = Modifier.padding(vertical = 10.dp),
//                text = "Continue With Phone",
//                fontSize = 20.sp,
//                onClick = {navController.navigate(Screen.PhoneAuth.route)}
//            )
//            Text(text = "Already have an account ? Login ",
//                modifier = Modifier.clickable { navController.navigate(Screen.Login.route) })
//        }
//    }
//}
//
//@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
//@Composable
//@Preview
//fun SignUpPreview() {
//    val navController = rememberNavController()
//    SignUp(navController = navController)
//}

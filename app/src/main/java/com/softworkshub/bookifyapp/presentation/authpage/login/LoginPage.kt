//package com.softworkshub.bookifyapp.presentation.authpage.login
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
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
//
//
//@Composable
//fun LoginPage(
//    navController: NavHostController
//) {
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
//                text = "Login",
//                color = colorResource(id = R.color.black),
//                fontSize = 40.sp,
//                fontWeight = FontWeight.Bold,
//            )
//
//            Text(
//                text = "It is easier to Login now",
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
//                text = "Login With Facebook",
//                fontSize = 20.sp,
//                onClick = {},
//                shape = RoundedCornerShape(50.dp),
//                width = 300.dp
//            )
//
//            ButtonSubmit(
//                modifier = Modifier.padding(vertical = 10.dp),
//                image = painterResource(id = R.drawable.google),
//                text = "Login With Google",
//                fontSize = 20.sp,
//                onClick = {},
//                shape = RoundedCornerShape(50.dp),
//                width = 300.dp
//            )
//
//            BorderButton(
//                modifier = Modifier.padding(vertical = 10.dp),
//                text = "Login With Phone",
//                fontSize = 20.sp,
//                onClick = {navController.navigate(Screen.PhoneAuth.route)}
//            )
//            Text(text = "Not a member ? Sign Up ",
//                modifier = Modifier.clickable {
//                    navController.navigate(Screen.SignUp.route)
//                }
//            )
//        }
//    }
//}
//
//@Preview
//@Composable
//fun LoginPagePreview(){
//    val navController = rememberNavController()
//    LoginPage(navController)
//}
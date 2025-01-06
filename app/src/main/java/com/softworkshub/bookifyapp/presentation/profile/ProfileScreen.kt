package com.softworkshub.bookifyapp.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softworkshub.bookifyapp.R

@Composable
fun ProfileScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.brownBackground))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Profile Picture
            Box(
                modifier = Modifier
                    .size(150.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pngegg),
                    contentDescription = "Profile Picture",
                    modifier = Modifier.size(150.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Username
            Text(
                text = "@username",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Edit Profile Button
            ElevatedButton(
                onClick = { /* Add your action here */ },
                colors = ButtonDefaults.elevatedButtonColors(
                    contentColor = colorResource(id = R.color.black),
                    containerColor = colorResource(id = R.color.continueButton)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp,
                    focusedElevation = 10.dp,
                    hoveredElevation = 30.dp,
                ),
            ) {
                Text(text = "Edit Profile")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Divider
            Divider()


            ProfileOptionsRow(
                iconId = R.drawable.baseline_settings_24,
                text = "Settings"
            )

            ProfileOptionsRow(
                iconId = R.drawable.bookinglogo,
                text = "My Bookings"
            )

            ProfileOptionsRow(
                iconId = R.drawable.baseline_location_on_24,
                text = "Address"
            )

            ProfileOptionsRow(
                iconId = R.drawable.passwordc,
                text = "Change Password"
            )

            Divider()
            Spacer(modifier = Modifier.height(10.dp))

            ProfileOptionsRow(
                iconId = R.drawable.help,
                text = "Help & Support"
            )

            ProfileOptionsRow(
                iconId = R.drawable.baseline_exit_to_app_24,
                text = "Log out"
            )
        }
    }

}

@Composable
fun ProfileOptionsRow(iconId: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = text,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun Divider() {
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(3.dp)
            .background(colorResource(R.color.black))
    )
}

@Preview
@Composable
fun ProfileScreenPreview(){
    ProfileScreen()
}
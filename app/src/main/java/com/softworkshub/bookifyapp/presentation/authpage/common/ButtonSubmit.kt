package com.softworkshub.bookifyapp.presentation.authpage.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softworkshub.bookifyapp.R

@Composable
fun ButtonSubmit(
    modifier: Modifier = Modifier,
    text: String = "Continue With Google",
    padding: Dp = 16.dp,
    fontSize: TextUnit ,
    onClick: () -> Unit,
    width: Dp = 300.dp, // Increased width for better layout
    fontWeight: FontWeight = FontWeight.Bold,
    color: Color = colorResource(id = R.color.continueButton),
    shape: Shape = RoundedCornerShape(50.dp),
    image: Painter = painterResource(id = R.drawable.fb)
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .clickable { onClick() }
            .width(width)
            .height(50.dp)
            .clip(shape)
            .background(color = color),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp) // Added padding for Row contents
        ) {
            Image(
                painter = image,
                contentDescription = "Button Icon",
                modifier = Modifier.padding(end = 8.dp).size(24.dp)
            )
            Text(
                text = text,
                fontSize = fontSize,
                color = Color.Black,
                fontWeight = fontWeight
            )
        }
    }
}

@Composable
@Preview
fun ButtonSubmitPreview() {
    ButtonSubmit(
        onClick = { /* Handle click */ },
        modifier = Modifier.fillMaxWidth(),
        text = "Continue With Google",
        fontSize = 15.sp,
    )
}

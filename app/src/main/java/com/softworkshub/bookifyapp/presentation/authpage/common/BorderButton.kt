package com.softworkshub.bookifyapp.presentation.authpage.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
fun BorderButton(
    modifier: Modifier = Modifier,
    text: String,
    width: Dp = 300.dp,
    fontSize: TextUnit,
    backgroundColor: Color = colorResource(id = R.color.brownBackground),
    onClick: () -> Unit,
    shape: Shape = RoundedCornerShape(50.dp),
    image: Painter = painterResource(id = R.drawable.call),
    fontWeight: FontWeight = FontWeight.Bold,
) {
    Box(
        modifier = modifier
            .width(width)
            .height(50.dp)
            .clip(shape)
            .border(BorderStroke(2.dp, colorResource(id = R.color.black)), shape = shape)
            .background(color = backgroundColor)
            .clickable { onClick() }
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = image,
                contentDescription = "Phone icon",
                modifier = Modifier.padding(end = 8.dp)
                    .size(24.dp)
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
fun BorderButtonPreview() {
    BorderButton(
        text = "Continue With Phone No",
        modifier = Modifier.fillMaxWidth(),
        fontSize = 20.sp,
        onClick = {}
    )
}

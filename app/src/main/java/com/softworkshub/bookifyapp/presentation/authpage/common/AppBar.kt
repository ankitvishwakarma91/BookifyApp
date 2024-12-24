package com.softworkshub.bookifyapp.presentation.authpage.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.softworkshub.bookifyapp.R
import com.softworkshub.bookifyapp.util.Dimens.IconMedium

@OptIn(ExperimentalMaterial3Api::class) // Required for Material3 TopAppBar
@Composable
fun AppBar() {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme
                    .typography
                    .headlineMedium
                    .copy(fontWeight = FontWeight.Normal),
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* Handle navigation icon click here */ }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    modifier = Modifier.size(IconMedium),
                    contentDescription = stringResource(id = R.string.navigation_menu)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.brownBackground)
        ),
    )
}

@Preview
@Composable
fun AppBarPreview() {
    AppBar()
}

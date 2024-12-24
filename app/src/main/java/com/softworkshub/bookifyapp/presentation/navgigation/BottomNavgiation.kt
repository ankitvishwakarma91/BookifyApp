package com.softworkshub.bookifyapp.presentation.navgigation


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.softworkshub.bookifyapp.R
import com.softworkshub.bookifyapp.util.Dimens.MediumElevation
import com.softworkshub.bookifyapp.util.Dimens.MediumHeight

@Composable
fun BottomNavigationView(
    items: List<BottomNav>,
    selected: Int,
    onSelectedItem: (Int) -> Unit,
) {

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = MediumElevation,
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selected == index,
                onClick = {
                    onSelectedItem(index)
                },
                icon = {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.height(MediumHeight))
                        Text(text = stringResource(id = item.text))
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = colorResource(id = R.color.body),
                    unselectedTextColor = colorResource(id = R.color.body),
                    indicatorColor = MaterialTheme.colorScheme.background,
                )
            )
        }
    }

}

data class BottomNav(
    @DrawableRes val icon: Int,
    @StringRes val text: Int,
)

@Preview
@Composable
fun BottomNavigationViewPreview() {

    val item = listOf(
        BottomNav(
            icon = R.drawable.baseline_home_24,
            text = R.string.home,
        ),

        BottomNav(
            icon = R.drawable.baseline_explore_24,
            text = R.string.explore,
        ),
        BottomNav(
            icon = R.drawable.baseline_apps_24,
            text = R.string.bookings,
        ),
        BottomNav(
            icon = R.drawable.baseline_person_24,
            text = R.string.profile,
        ),
    )

    BottomNavigationView(
        items = item,
        selected = 0,
        onSelectedItem = {}
    )

}
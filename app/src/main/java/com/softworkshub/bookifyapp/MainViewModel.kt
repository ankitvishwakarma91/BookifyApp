package com.softworkshub.bookifyapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softworkshub.bookifyapp.domain.usecases.app_entry.AppEntryUseCases
import com.softworkshub.bookifyapp.presentation.navgigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {

    var startDestination by mutableStateOf(Screen.LoginPage.route)
        private set

    init {
        appEntryUseCases.readAppEntry()
            .onEach { shouldStartFromHomeScreen ->
                startDestination = if (shouldStartFromHomeScreen) {
                    Screen.AppNavigator.route // Direct main app start
                } else {
                    Screen.LoginPage.route // Start at login
                }
            }
            .catch {
                startDestination = Screen.LoginPage.route // Fallback to LoginPage
            }
            .launchIn(viewModelScope)
    }
}

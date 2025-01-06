package com.softworkshub.bookifyapp.presentation.authpage.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softworkshub.bookifyapp.domain.usecases.app_entry.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {

    fun onEvent(event: LoginEvent){
        when(event){
            is LoginEvent.SaveAppEntry -> {
                saveUseEntry()
            }
        }
    }

    private fun saveUseEntry(){
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }
    }
}
package com.softworkshub.bookifyapp.presentation.authpage.login

sealed class LoginEvent{
    data object SaveAppEntry:LoginEvent()
}

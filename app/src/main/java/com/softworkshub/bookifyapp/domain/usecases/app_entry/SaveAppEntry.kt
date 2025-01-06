package com.softworkshub.bookifyapp.domain.usecases.app_entry

import com.softworkshub.bookifyapp.domain.manager.LocalUserManager
import javax.inject.Inject

class SaveAppEntry @Inject constructor(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveEntry()
    }
}
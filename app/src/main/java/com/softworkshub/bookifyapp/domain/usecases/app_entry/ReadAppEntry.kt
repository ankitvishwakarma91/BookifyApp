package com.softworkshub.bookifyapp.domain.usecases.app_entry

import com.softworkshub.bookifyapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class ReadAppEntry @Inject constructor(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readEntry()
    }
}
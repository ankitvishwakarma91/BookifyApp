package com.softworkshub.bookifyapp.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {

    suspend fun saveEntry()

    fun readEntry() : Flow<Boolean>
}
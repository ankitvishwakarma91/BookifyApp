package com.softworkshub.bookifyapp.di

import android.app.Application
import com.softworkshub.bookifyapp.data.manager.LocalUserManagerImpl
import com.softworkshub.bookifyapp.domain.manager.LocalUserManager
import com.softworkshub.bookifyapp.domain.usecases.app_entry.AppEntryUseCases
import com.softworkshub.bookifyapp.domain.usecases.app_entry.ReadAppEntry
import com.softworkshub.bookifyapp.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ) : LocalUserManager {
        return LocalUserManagerImpl(context = application )
    }

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ):AppEntryUseCases {
        return AppEntryUseCases(
            readAppEntry = ReadAppEntry(localUserManager),
            saveAppEntry = SaveAppEntry(localUserManager)
        )
    }

}
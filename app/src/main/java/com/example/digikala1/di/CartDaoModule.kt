package com.example.digikala1.di

import com.example.digikala1.data.db.CartDao
import com.example.digikala1.data.db.DigikalaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CartDaoModule {
    @Provides
    @Singleton
    fun provideCartDao(database: DigikalaDatabase): CartDao =
        database.cartDao()

}
package com.example.trackercaloriesapp.app.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.trackercaloriesapp.core.data.preferences.DefaultPreferences
import com.example.trackercaloriesapp.core.domain.preferences.Preferences
import com.example.trackercaloriesapp.core.domain.use_case.FilterOutDigits
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.Serializable
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences{
        return app.getSharedPreferences("sheared_pref",MODE_PRIVATE)
    }
    @Provides
    @Singleton
    fun provideReferences(sharedPreferences: SharedPreferences): Preferences {
        return DefaultPreferences(sharedPreferences)
    }


    @Provides
    @Singleton
    fun provideFilterOutDigitsUseCase(): FilterOutDigits{
        return FilterOutDigits()
    }

}
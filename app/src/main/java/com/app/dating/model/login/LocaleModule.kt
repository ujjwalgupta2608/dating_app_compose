package com.app.dating.model.login

import android.content.Context
import com.app.dating.ui.screen.language.LocaleManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocaleModule {

    @Provides
    @Singleton
    fun provideLocaleManager(@ApplicationContext context: Context): LocaleManager {
        return LocaleManager(context)
    }
}

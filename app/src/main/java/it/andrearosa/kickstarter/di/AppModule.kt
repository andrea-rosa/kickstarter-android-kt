package it.andrearosa.kickstarter.di

import android.content.Context
import dagger.Module
import dagger.Provides
import it.andrearosa.kickstarter.App
import it.andrearosa.kickstarter.db.AppDatabase
import it.andrearosa.kickstarter.service.RestClient
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideRestClient(): RestClient {
        return RestClient()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(): AppDatabase {
        return AppDatabase.getInstance(App.app)!!
    }
}

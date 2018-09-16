package it.andrearosa.kickstarter.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import it.andrearosa.kickstarter.activities.MainActivity

@Module
abstract class MainActivityInjector {
    @ContributesAndroidInjector
    abstract fun contributeMainActivityInjector(): MainActivity
}

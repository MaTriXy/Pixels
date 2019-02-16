package beepbeep.pixelsforredditx.di

import android.app.Application
import android.content.Context
import com.worker8.redditapi.RedditApi
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class AppModule() {
    @Binds
    abstract fun provideContext(application: Application): Context
}
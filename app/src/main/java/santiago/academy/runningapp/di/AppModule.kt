package santiago.academy.runningapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import santiago.academy.runningapp.db.RunningDatabase
import santiago.academy.runningapp.other.Constants.RUNNING_DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule(){

    @Singleton
    @Provides
    fun provideRunningDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(
        db: RunningDatabase
    ) = db.getRunDao()

}

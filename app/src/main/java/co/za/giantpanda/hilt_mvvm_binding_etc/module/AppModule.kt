package co.za.giantpanda.hilt_mvvm_binding_etc.module

import android.content.Context
import co.za.giantpanda.hilt_mvvm_binding_etc.db.AppDao
import co.za.giantpanda.hilt_mvvm_binding_etc.db.AppDatabase
import co.za.giantpanda.hilt_mvvm_binding_etc.network.RetroServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule{

  @Provides
  @Singleton
  fun getAppDatabase(context : Context): AppDatabase {
    return AppDatabase.getAppDBInstance(context)
  }

  @Provides
  @Singleton
  fun getAppDao(appDatabase: AppDatabase): AppDao {
    return appDatabase.getAppDao()
  }

  val BASE_URL = "https://api.github.com/search/"

  @Provides
  @Singleton
  fun getRetroServiceInstance(retrofit: Retrofit): RetroServiceInterface {
    return retrofit.create(RetroServiceInterface::class.java)
  }

  @Singleton
  @Provides
  fun getRetroInstance(): Retrofit {
    return Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

}
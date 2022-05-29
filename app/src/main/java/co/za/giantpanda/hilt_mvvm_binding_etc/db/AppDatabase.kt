package co.za.giantpanda.hilt_mvvm_binding_etc.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dagger.hilt.android.qualifiers.ApplicationContext

@Database(entities = [RepositoriesData::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverterOwner::class)
abstract class AppDatabase : RoomDatabase() {

  abstract fun getAppDao(): AppDao

  companion object {

    private lateinit var DB_INSTANCE: AppDatabase

    fun getAppDBInstance(context: Context): AppDatabase {
      if (DB_INSTANCE == null) {
        DB_INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "APP_DB")
          .allowMainThreadQueries()
          .build()
      }
      return DB_INSTANCE
    }
  }
}
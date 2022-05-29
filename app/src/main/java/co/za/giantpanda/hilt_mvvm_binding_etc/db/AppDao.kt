package co.za.giantpanda.hilt_mvvm_binding_etc.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
  interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItems(repositoriesData: RepositoriesData)

    @Query("SELECT * FROM repositories")
    fun getAllRecords(): LiveData<List<RepositoriesData>>

    @Query("DELETE  FROM repositories")
    fun deleteAllRecords()

}

package co.za.giantpanda.hilt_mvvm_binding_etc.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repositories")
data class RepositoriesData(
        @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id")
        val id: Int = 0,

        @ColumnInfo(name = "name")
        val name : String?,

        @ColumnInfo(name = "description")
        val description : String?,

        @ColumnInfo(name = "owner")
        val owner : Owner?)

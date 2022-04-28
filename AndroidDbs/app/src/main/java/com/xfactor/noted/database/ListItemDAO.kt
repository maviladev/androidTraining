package com.xfactor.noted.database

import androidx.room.*

@Dao
interface ListItemDao {
    @Query("SELECT * FROM listitem")
    fun getAll(): kotlin.collections.List<ListItem>

    @Insert
    fun insertAll(vararg listitems: com.xfactor.noted.database.ListItem)

    @Delete
    fun delete(listitem: com.xfactor.noted.database.ListItem)
}
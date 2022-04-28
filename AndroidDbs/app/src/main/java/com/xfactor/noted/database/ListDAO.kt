package com.xfactor.noted.database

import androidx.room.*
import kotlin.collections.List

@Dao
interface ListDao {
    @Query("SELECT * FROM list")
    fun getAll(): List<com.xfactor.noted.database.List>

    @Query("SELECT * FROM list where title LIKE '%Favorite%'")
    fun getAllFavorites(): List<ListWithListItems>

    @Transaction
    @Query("SELECT * FROM list")
    fun getListsWithListItems(): List<ListWithListItems>

    @Insert
    fun insertAll(vararg lists: com.xfactor.noted.database.List)

    @Delete
    fun delete(list: com.xfactor.noted.database.List)
}
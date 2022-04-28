package com.xfactor.noted.database.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_2_3 = object  : Migration(2,3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE `ListItem` ADD COLUMN order_number INTEGER")
    }
}
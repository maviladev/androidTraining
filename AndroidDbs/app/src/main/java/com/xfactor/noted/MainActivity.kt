package com.xfactor.noted

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.xfactor.noted.database.AppDatabase
import com.xfactor.noted.database.migrations.MIGRATION_1_2
import com.xfactor.noted.database.migrations.MIGRATION_2_3

lateinit var appDatabase: AppDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "noted-database").allowMainThreadQueries().addMigrations(
            MIGRATION_1_2, MIGRATION_2_3).build()

        // Setting ActionBar logo
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.ic_logo)
        supportActionBar?.setDisplayUseLogoEnabled(true)


        setContentView(R.layout.activity_main)

        // Setup navigation
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_delete, R.id.navigation_listcontainer, R.id.navigation_newlist))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //val listDAO = db.listDAO()
        //val listItemDao = db.listItemDAO()

        //Log.e("Lists", listDAO.getAll().toString())
        //Log.e("ListItems", listItemDao.getAll().toString())

        //val lastId = if (lists.isEmpty()) 0 else lists.last().uid + 1

        //listItemDao.insertAll(ListItem(uid=3, listId = listDAO.getAll()[0].uid, value = "Test Item!"))

        //Log.e("Lists", listDAO.getListWithListItems()[0].ListItems.toString())
        //Log.e("ListItems", listItemDao.getAll().toString())

        //listDAO.delete(lists[0])

        //Log.e("Lists", listDAO.getAll().toString())

        getLists().forEach { list-> list.ListItems.forEachIndexed { index, listItem ->
            listItem.order_number = index
            appDatabase.listItemDao().update(listItem)
        } }
        getLists().forEach { list-> Log.e("Elements", list.ListItems.toString()) }

    }
}



package com.xfactor.noted

import com.xfactor.noted.database.ListItem
import com.xfactor.noted.database.ListWithListItems

val ListsToCompare = mutableListOf<ListWithListItems>()

fun getLists() : List<ListWithListItems> {
    return appDatabase.listDao().getListsWithListItems()
}

fun getFavoritesList(): List<ListWithListItems> {
    return appDatabase.listDao().getAllFavorites()
}

fun getListItems(): List<ListItem> {
    return appDatabase.listItemDao().getAll()
}

fun addList(list: ListWithListItems) {
    appDatabase.listDao().insertAll(list.list)
    appDatabase.listItemDao().insertAll(*list.ListItems.toTypedArray())
}

fun deleteList(list: ListWithListItems) {
    appDatabase.listDao().delete(list.list)
}

fun getSubItems(item: ListWithListItems):String {
    val inListForm = item.ListItems.mapIndexed {idx, value -> (idx+1).toString().plus(". ").plus(value.value)}
    return inListForm.joinToString("\n")
}
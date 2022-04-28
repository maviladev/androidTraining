package com.xfactor.noted.ui.add

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xfactor.noted.database.ListItem
import com.xfactor.noted.database.ListWithListItems
import com.xfactor.noted.getListItems
import com.xfactor.noted.getLists

class NewlistViewModel : ViewModel() {

    private val lastId = if(getLists().size == 0) 1 else getLists().last().list.uid + 1
    private val lastElementId = if (getListItems().size == 0) 1 else getListItems().last().uid + 1

    private var _listItem = MutableLiveData<ListWithListItems>().apply {
        value = ListWithListItems(com.xfactor.noted.database.List(lastId, "Example title"), mutableListOf())
    }
    var listItem: LiveData<ListWithListItems> = _listItem
    fun setTitle(title:String) {
        _listItem.postValue(ListWithListItems(com.xfactor.noted.database.List(_listItem.value!!.list.uid, title), _listItem.value!!.ListItems))
    }
    fun addItem(item:String){
        val currentVal = _listItem.value ?: return
        val elements = currentVal.ListItems
        _listItem.postValue(
            ListWithListItems(com.xfactor.noted.database.List(currentVal.list.uid, currentVal.list.title), elements.plus(
            ListItem(
            lastElementId, currentVal.list.uid, item)
        ))
        )
        Log.e("list uid", currentVal.list.uid.toString())
        Log.e("list element uid", (getListItems().size + 1).toString())
    }
}
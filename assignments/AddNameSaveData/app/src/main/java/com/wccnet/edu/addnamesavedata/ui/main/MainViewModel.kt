package com.wccnet.edu.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var nameList = ArrayList<String>()

    fun addName(name: String) {
        this.nameList.add(name)
    }
    fun getNames(): ArrayList<String> {
        return nameList
    }
    fun sort() {
        nameList = ArrayList(nameList.sortedWith(compareBy({it.lowercase()})))
    }
    fun sortDescend() {
        nameList = ArrayList(nameList.sortedWith(compareByDescending({it.lowercase()})))
    }
}
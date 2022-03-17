package com.wccnet.edu.addnamesavedata.ui.main
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log

class MainViewModel : ViewModel() {
    private var text: MutableLiveData<String> = MutableLiveData("")
    private var nameList = ArrayList<String>()
    private var names: MutableLiveData<String> = MutableLiveData("")
    private var bool: MutableLiveData<Boolean> = MutableLiveData(false)
    private var clearBool: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getBool(): MutableLiveData<Boolean> {
        return bool
    }
    fun getClearBool(): MutableLiveData<Boolean> {
        return clearBool
    }
    fun setText(name: String) {
        text.value = name
    }
    fun getText(): MutableLiveData<String> {
        return text
    }
    fun addName(name: String) {
        if (name.isEmpty()) return
        this.nameList.add(name)
        names.value = getNamesAsString()
        text.value = ""
        if (bool.value == false && nameList.size > 1) {
            bool.value = true
        }
        if (clearBool.value == false) {
            clearBool.value = true
        }
    }
    fun clear() {
        nameList.clear()
        names.value = ""
        bool.value = false
        clearBool.value = false
    }
    fun getNames(): MutableLiveData<String> {
        Log.d("Log","in get")
        return names
    }
    fun sort() {
        nameList = ArrayList(nameList.sortedWith(compareBy({it.lowercase()})))
        names.value = getNamesAsString()
    }
    fun sortDescend() {
        nameList = ArrayList(nameList.sortedWith(compareByDescending({it.lowercase()})))
        names.value = getNamesAsString()
    }
    private fun getNamesAsString(): String {
        var namestring = ""
        for (name in nameList) {
            namestring = "" + namestring + name + "\n"
        }
        return namestring
    }
}
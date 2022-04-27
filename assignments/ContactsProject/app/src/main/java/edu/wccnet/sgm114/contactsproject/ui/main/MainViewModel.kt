package edu.wccnet.sgm114.contactsproject.ui.main

import androidx.lifecycle.ViewModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import edu.wccnet.sgm114.contactsproject.Contact
import edu.wccnet.sgm114.contactsproject.ContactRepository
import java.lang.Integer.parseInt

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ContactRepository = ContactRepository(application)
    private var allContacts: LiveData<List<Contact>>? = repository.allContacts
    private val searchResults: MutableLiveData<List<Contact>> = repository.searchResults
    fun insertContact(contact:Contact) {
        repository.insertContact(contact)
    }
    fun getSearchResults():MutableLiveData<List<Contact>> {
        return searchResults
    }
    fun deleteContact(id:String) {
        var idNum: Int = parseInt(id)
        repository.deleteContact(idNum)
    }
    fun getAllContacts():LiveData<List<Contact>>? {
        return allContacts
    }
}
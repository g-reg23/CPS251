package edu.wccnet.sgm114.contactsproject
import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {
    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDAO?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    var allContacts: LiveData<List<Contact>>?
    fun insertContact(newContact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newContact)
        }
    }
    private suspend fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }
    fun deleteContact(id:Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }
    private suspend fun asyncDelete(id: Int) {
        contactDao?.deleteContact(id)
    }
    fun findContact(name:String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name)
        }
    }
    private suspend fun asyncFind(name:String): List<Contact>? = coroutineScope.async(Dispatchers.IO) {
        return@async contactDao?.findContact(name)
    }.await()
    fun sortContactsAsc():LiveData<List<Contact>>? {
        var list: LiveData<List<Contact>>? = null
        Log.i("Repo", "hit there")
        coroutineScope.launch(Dispatchers.Main) {
            list = asyncSortAsc()
        }
        Log.i("Repo", list.toString())
        return list
    }
    private suspend fun asyncSortAsc(): LiveData<List<Contact>>? {
        return contactDao?.sortContactsAsc()
    }
    init {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
    }
}
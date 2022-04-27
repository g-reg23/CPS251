package edu.wccnet.sgm114.contactsproject
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDAO {
    @Insert
    fun insertContact(contact: Contact)
    @Query("Select * from contacts where contactName = :name")
    fun findContact(name:String):List<Contact>
    @Query("Delete from contacts where contactId = :id")
    fun deleteContact(id:Int)
    @Query("Select * from contacts")
    fun getAllContacts():LiveData<List<Contact>>
    @Query("SELECT * FROM contacts ORDER BY contactName ASC")
    fun sortContactsAsc():LiveData<List<Contact>>
    @Query("SELECT * FROM contacts ORDER BY contactName DESC")
    fun sortContactsDesc():List<Contact>

}
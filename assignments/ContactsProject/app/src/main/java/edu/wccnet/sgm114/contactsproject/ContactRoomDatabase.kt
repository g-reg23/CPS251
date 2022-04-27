package edu.wccnet.sgm114.contactsproject
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.wccnet.sgm114.contactsproject.Contact
import edu.wccnet.sgm114.contactsproject.ContactDAO

@Database(entities = [(Contact::class)], version = 1, exportSchema = false)
 abstract class ContactRoomDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDAO
    companion object {
        private var INSTANCE: ContactRoomDatabase? = null
        internal fun getDatabase(context: Context):ContactRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder<ContactRoomDatabase>(
                        context.applicationContext,
                        ContactRoomDatabase::class.java,
                        "contact_database").build()
                }
            }
            return INSTANCE
        }
    }
}
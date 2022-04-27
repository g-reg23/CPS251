package edu.wccnet.sgm114.contactsproject
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "contactId")
    var id: Int = 0
    @ColumnInfo(name = "contactName")
    var name: String? = null
    @ColumnInfo(name = "contactNumber")
    var number: String? = null
    constructor(){}
    constructor(id:Int, conName:String, conNumber:String) {
        this.name = conName
        this.number = conNumber
    }
    constructor(conName:String, conNumber:String) {
        this.name = conName
        this.number = conNumber
    }
}
package edu.wccnet.sgm114.contactsproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import edu.wccnet.sgm114.contactsproject.Contact
import edu.wccnet.sgm114.contactsproject.R
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import edu.wccnet.sgm114.contactsproject.ui.main.MainFragment

class ContactListAdapter(private val contactItemLayout:Int): RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {
    private var contactList: List<Contact>? = null
    private var mainFragment: MainFragment? = null
    var listener: onItemClickListener? = null
    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val name = holder.name
        val number = holder.number
        val delete = holder.button
        val id = holder.id
        contactList.let {
            name.text = it!![listPosition].name
            number.text = it!![listPosition].number
            id.text = it!![listPosition].id.toString()
        }
        delete.setOnClickListener {
            listener?.onClick(id.text.toString())
        }

    }
    fun settingListener(listener: onItemClickListener?) {
        this.listener = listener
    }
    interface onItemClickListener {
        fun onClick(str: String) //pass your object types.
    }
    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ViewHolder(view)
    }
    fun setContactList(contacts: List<Contact>) {
        mainFragment = MainFragment()
        contactList = contacts
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.itemName)
        var number: TextView = itemView.findViewById(R.id.itemNumber)
        var button: ImageView = itemView.findViewById(R.id.button)
        var id: TextView = itemView.findViewById(R.id.idTV)
    }
}
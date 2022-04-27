package edu.wccnet.sgm114.contactsproject.ui.main


import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import edu.wccnet.sgm114.contactsproject.Contact
import edu.wccnet.sgm114.contactsproject.ContactListAdapter
import edu.wccnet.sgm114.contactsproject.R
import edu.wccnet.sgm114.contactsproject.databinding.MainFragmentBinding


class MainFragment : Fragment() {

    private var adapter: ContactListAdapter? = null
    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()
    private var _binding:MainFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listenerSetup()
        observerSetup()
        recyclerSetup()
    }
    private fun clearFields() {
        binding.nameET.setText("")
        binding.phoneET.setText("")
        binding.errorTV.text = ""
    }
    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.nameET.text.toString()
            val number = binding.phoneET.text.toString()
            if (name.isEmpty() || number.isEmpty()) {
                binding.errorTV.text = "Please Enter some datar."
            }else  {
                val contact = Contact(name, number)
                viewModel.insertContact(contact)
                clearFields()
            }
        }
        binding.ascButton.setOnClickListener {
            viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer {contacts ->
                contacts?.let {
                    val sorted = ArrayList(it.sortedWith(compareBy { it.name.toString().lowercase() }))
                    adapter?.setContactList(sorted)
                }
            })
        }
        binding.descButton.setOnClickListener {
            viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer {contacts ->
                contacts?.let {
                    val sorted = ArrayList(it.sortedWith(compareByDescending{ it.name.toString().lowercase() }))
                    adapter?.setContactList(sorted)
                }
            })
        }
        binding.findButton.setOnClickListener {
            val name = binding.nameET.text.toString()
            val number = binding.phoneET.text.toString()
            var that = it
            if (name.isNotEmpty()) {
                viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer {contacts ->
                    contacts?.let {
                        var filtered = contacts.filter { x -> x.name?.lowercase()!!.contains(name.lowercase()) }
                        if (filtered.isEmpty()) {
                            val text = "Search found no results, please search again."
                            val duration = Toast.LENGTH_LONG
                            val toast = Toast.makeText(that.context, text, duration)
                            toast.show()
                        }
                        adapter?.setContactList(filtered)
                        clearFields()
                    }
                })
            } else if (number.isNotEmpty()) {
                viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer {contacts ->
                    contacts?.let {
                        var filtered = contacts.filter { x -> x.number!!.contains(number) }
                        if (filtered.isEmpty()) {
                            val text = "Search found no results, please search again."
                            val duration = Toast.LENGTH_LONG
                            val toast = Toast.makeText(that.context, text, duration)
                            toast.show()
                        }
                        adapter?.setContactList(filtered)
                        clearFields()
                    }
                })
            } else {
                viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer {contacts ->
                    contacts?.let {
                        adapter?.setContactList(it)
                    }
                })            }
        }

    }
    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer {contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        })

        viewModel.getSearchResults()?.observe(viewLifecycleOwner, Observer {
            it?.let {contacts ->
                if (contacts.isNotEmpty()) {
                    binding.nameET.setText(it[0].name.toString())
                    binding.phoneET.setText(it[0].number.toString())
                }else {
                    binding.nameET.setText("No Match")
                }
            }
        })
    }
    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.id.contactRow)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter
        adapter!!.settingListener(object: ContactListAdapter.onItemClickListener {
            override fun onClick(str: String) {
                Log.i("ID", str)
                viewModel.deleteContact(str)
            }

        })
    }
}
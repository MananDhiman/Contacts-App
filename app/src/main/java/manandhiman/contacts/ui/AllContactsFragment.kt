package manandhiman.contacts.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import manandhiman.contacts.databinding.FragmentAllContactsBinding
import manandhiman.contacts.model.AppDatabase
import manandhiman.contacts.model.ContactDao
import manandhiman.contacts.model.ContactsAdapter

class AllContactsFragment : Fragment() {
    private lateinit var binding: FragmentAllContactsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllContactsBinding.inflate(layoutInflater, container, false)

        val db = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java, "contacts",
        ).allowMainThreadQueries().build()

        val contactDao = db.contactDao()

        getContacts(contactDao)

        return binding.root
    }

    private fun getContacts(contactDao: ContactDao) {
        val listContact = contactDao.getAll()

        if(listContact.isEmpty()){
            //show no contacts
            return
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = ContactsAdapter(listContact)
        binding.recyclerView.adapter = adapter


//        binding.textView3.text = ""
//        for(i in listContact.indices) binding.textView3.text =
//            "${listContact[i].id} + ${listContact[i].name} + ${listContact[i].phoneNumber}"
    }

}
package manandhiman.contacts.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import manandhiman.contacts.databinding.FragmentAllContactsBinding
import manandhiman.contacts.model.AppDatabase
import manandhiman.contacts.model.ContactDao

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
            binding.textView3.text = "No Contacts"
            return
        }

        binding.textView3.text = ""
        for(i in listContact.indices) binding.textView3.text =
            "${listContact[i].id} + ${listContact[i].name} + ${listContact[i].phoneNumber}"
    }

}
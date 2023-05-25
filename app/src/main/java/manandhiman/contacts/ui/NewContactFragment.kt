package manandhiman.contacts.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import manandhiman.contacts.databinding.FragmentNewContactBinding
import manandhiman.contacts.model.AppDatabase
import manandhiman.contacts.model.Contact
import manandhiman.contacts.model.ContactDao

class NewContactFragment : Fragment() {

    private lateinit var binding: FragmentNewContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewContactBinding.inflate(layoutInflater, container, false)

        val db = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java, "contacts",
        ).allowMainThreadQueries().build()

        val contactDao = db.contactDao()

        binding.buttonSave.setOnClickListener{
            addNewContact(contactDao)
        }



        return binding.root
    }

    private fun addNewContact(contactDao: ContactDao) {

        //validateContact()
        //checkIfContactExists

        val name: String = binding.editTextName.text.toString()
        val phone: Int = binding.editTextPhoneNumber.text.toString().toInt()
        val email: String = binding.editTextTextEmail.text.toString()
        val houseAddress: String = binding.editTextTextAddress.text.toString()

        val newContact = Contact(name, phone, email, houseAddress)
        contactDao.insertContact(newContact)

    }
}
package manandhiman.contacts.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.savedstate.findViewTreeSavedStateRegistryOwner
import manandhiman.contacts.R

class ContactsAdapter(private val contactsList: List<Contact>):
RecyclerView.Adapter<ContactsAdapter.ViewHolder>(){

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsAdapter.ViewHolder, position: Int) {
        val contact = contactsList[position]

        val contactId = contact.id
        holder.textViewName.text = contact.name
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }
}
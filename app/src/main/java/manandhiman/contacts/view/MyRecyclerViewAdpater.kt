package manandhiman.contacts.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import manandhiman.contacts.R
import manandhiman.contacts.databinding.CardItemBinding
import manandhiman.contacts.room.User

class MyRecyclerViewAdpater
    (private val usersList:List<User>,
        private val clickListener: (User) -> Unit
    ): RecyclerView.Adapter<MyRecyclerViewAdpater.MyViewHolder>() {

    class MyViewHolder(private val binding: CardItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User, clickListener: (User) -> Unit) {
            binding.nameTextView.text = user.name
            binding.emailTextView.text = user.email

            binding.listItemLayout.setOnClickListener{
                clickListener(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CardItemBinding = DataBindingUtil.
                inflate(layoutInflater, R.layout.card_item, parent, false)

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(usersList[position], clickListener)
    }

}
package manandhiman.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import manandhiman.contacts.viewModel.UserViewModel
import manandhiman.contacts.viewModel.UserViewModelFactory
import manandhiman.contacts.databinding.ActivityMainBinding
import manandhiman.contacts.room.User
import manandhiman.contacts.room.UserDatabase
import manandhiman.contacts.room.UserRepository
import manandhiman.contacts.view.MyRecyclerViewAdpater

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = UserDatabase.getInstance(application).userDAO
        val repository = UserRepository(dao)
        val factory = UserViewModelFactory(repository)

        userViewModel = ViewModelProvider(this,
            factory).get(UserViewModel::class.java)

        binding.userViewModel = userViewModel

        binding.lifecycleOwner = this

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        displaUsersList()
    }

    private fun displaUsersList() {
        userViewModel.users.observe(this, Observer {
            binding.recyclerView.adapter = MyRecyclerViewAdpater(
                it, {selectedItem: User -> listItemClicked(selectedItem)}
            )
        })
    }

    private fun listItemClicked(selectedItem: User) {
        Toast.makeText(this, "Selected name is ${selectedItem.name}"
        ,Toast.LENGTH_LONG).show()

         userViewModel.initUpdateAndDelete(selectedItem)
    }
}
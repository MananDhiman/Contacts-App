package manandhiman.contacts.viewModel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import manandhiman.contacts.room.User
import manandhiman.contacts.room.UserRepository

class UserViewModel(private val repository: UserRepository): ViewModel(), Observable {

    val users = repository.users
    private var isUpdateOrDelete = false
    private lateinit var userToUpdateOrDelete: User

    @Bindable
    val inputName = MutableLiveData<String?>()

    @Bindable
    val inputEmail = MutableLiveData<String?>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButton = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButton.value = "Clear All"
    }

    fun saveOrUpdate() {
        if(isUpdateOrDelete) {
//            Update
            userToUpdateOrDelete.name = inputName.value!!
            userToUpdateOrDelete.email = inputEmail.value!!
            update(userToUpdateOrDelete)

        } else {
            val name = inputName.value!!
            val email = inputEmail.value!!

            insert(User(0, name, email))

            inputName.value = null
            inputEmail.value = null
        }

    }

    fun clearAllOrDelete() {
        if(isUpdateOrDelete) {
            delete(userToUpdateOrDelete)
        } else {
            clearAll()
        }

    }


    private fun clearAll() = viewModelScope.launch {
        repository.deleteAll()
    }

    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }

    fun update(user: User) = viewModelScope.launch {
        repository.update(user)

        resetButtonsAndEditTexts()
    }

    private fun resetButtonsAndEditTexts() {
        inputEmail.value = null
        inputName.value = null
        isUpdateOrDelete = false
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButton.value = "Clear All"
    }

    fun delete(user: User) = viewModelScope.launch {
        repository.delete(user)

        resetButtonsAndEditTexts()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) { }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) { }
    fun initUpdateAndDelete(user: User) {
        inputEmail.value = user.email
        inputName.value = user.name
        isUpdateOrDelete = true
        userToUpdateOrDelete = user
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButton.value = "Delete"
    }
}
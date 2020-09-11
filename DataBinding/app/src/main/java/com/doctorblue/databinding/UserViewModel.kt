package com.doctorblue.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val _firstName: MutableLiveData<String> = MutableLiveData("John")
    private val _lastName: MutableLiveData<String> = MutableLiveData("Smith")
    private val _likes: MutableLiveData<Int> = MutableLiveData(0)

    val firstName: LiveData<String> = _firstName
    val lastName: LiveData<String> = _lastName
    val likes: LiveData<Int> = _likes

    fun setFirstName(firstName: String) {
        _firstName.value = firstName
    }

    fun setLastName(lastName: String) {
        _lastName.value = lastName
    }

    fun onLikes() {
        _likes.value = (_likes.value ?: 0) + 1
    }
}
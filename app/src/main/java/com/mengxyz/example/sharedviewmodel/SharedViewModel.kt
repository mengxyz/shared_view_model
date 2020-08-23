package com.mengxyz.example.sharedviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _string = MutableLiveData<String>()
    val string = _string
    fun submitString(s:String) = _string.postValue(s)
}
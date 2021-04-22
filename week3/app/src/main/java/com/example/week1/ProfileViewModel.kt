package com.example.week1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel(var name:String, var email:String, var phone:String) : ViewModel() {

    var user : MutableLiveData<User> = MutableLiveData()
    init{
        user.value = User(name,email,phone)
    }
    fun setAccountUserName(Name: String){
        user.value?.name = Name
        user.postValue(user.value)
    }
    fun setAccountUserEmail(Email: String){
        user.value?.email = Email
        user.postValue(user.value)
    }
    fun setAccountUserPhone(Phone: String){
        user.value?.phoneNumber = Phone
        user.postValue(user.value)
    }
}
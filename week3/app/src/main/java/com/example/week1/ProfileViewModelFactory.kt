package com.example.week1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProfileViewModelFactory(val name: String, val email: String, val phone: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(name, email, phone) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

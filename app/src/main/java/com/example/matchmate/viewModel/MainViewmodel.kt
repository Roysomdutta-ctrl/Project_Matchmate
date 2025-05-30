package com.example.matchmate.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.matchmate.data.Local.AppDatabase
import com.example.matchmate.data.Local.UserEntity
import com.example.matchmate.data.remote.RetrofitClient
import com.example.matchmate.data.repository.UserRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val db = Room.databaseBuilder(application, AppDatabase::class.java, "user-db").build()
    private val repository = UserRepository(db.userDao(), RetrofitClient.apiService)

    val users = repository.users.asLiveData()

    fun fetchUsers() = viewModelScope.launch {
        try {
            repository.fetchUsersFromApi()
        } catch (e: Exception) {
            // Handle API error
        }
    }

    fun updateUserStatus(user: UserEntity, status: String) = viewModelScope.launch {
        repository.updateUser(user.copy(status = status))
    }
}

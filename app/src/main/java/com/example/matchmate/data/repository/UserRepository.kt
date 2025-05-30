package com.example.matchmate.data.repository

import com.example.matchmate.data.Local.UserDao
import com.example.matchmate.data.Local.UserEntity
import com.example.matchmate.data.remote.ApiService
import kotlinx.coroutines.flow.Flow

/**
 * The Repository coordinates data from Retrofit and Room.
 */

class UserRepository(private val dao: UserDao, private val api: ApiService) {
    val users: Flow<List<UserEntity>> = dao.getAllUsers()

    suspend fun fetchUsersFromApi() {
        val response = api.getUsers()
        val mapped = response.results.map {
            UserEntity(
                email = it.email,
                fullName = "${it.name.first} ${it.name.last}",
                imageUrl = it.picture.large,
                age = it.dob.age,
                location = "${it.location.city}, ${it.location.country}",
                status = "Pending"
            )
        }
        dao.insertAll(mapped)
    }

    suspend fun updateUser(user: UserEntity) {
        dao.updateUser(user)
    }
}
package com.example.matchmate.data.models

data class UserResponse(val results: List<User>)

data class User(
    val name: Name,
    val picture: Picture,
    val email: String,
    val gender: String,
    val dob: Dob,
    val location: Location
)


data class Name(val title: String, val first: String, val last: String)
data class Picture(val large: String)
data class Dob(val age: Int)
data class Location(val city: String, val country: String)
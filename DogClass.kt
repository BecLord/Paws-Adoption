package com.example.assignment1
//Data Class for Dog available for adoption
data class Dog(
    val id: String = "",
    val name: String = "",
    val breed: String = "",
    val age: Int = 0,
    val gender: String = "",
    val size: String = "",
    val location: String = "",
    val description: String = "",
    val image: String = ""
)

data class DogList(
    val dogs: List<Dog> = CurrentDogs.Dogs
)

package com.example.assignment1
//Data Class for Dog available for adoption
object CurrentDogs{
    val Dogs = listOf(
        Dog(
            id = "1",
            name = "Bart",
            breed = "Golden Retriever",
            age = 3,
            gender = "Male",
            size = "Medium",
            location = "Ballincollig, Cork",
            description = "A friendly and playful retriever.",
            image = ""
        ),
        Dog(
            id = "2",
            name = "Ivy",
            breed = "Labrador",
            age = 2,
            gender = "Female",
            size = "Large",
            location = "Kinsale, Cork",
            description = "A loyal and protective labrador",
            image = ""
        ),
        Dog(
            id = "3",
            name = "Ruby",
            breed = "Irish Red Setter",
            age = 6,
            gender = "Female",
            size = "Large",
            location = "Swords, Cork",
            description = "A friendly and intelligent setter",
            image = ""
            ),
        Dog(
            id = "4",
            name = "Max",
            breed = "German Shepherd",
            age = 4,
            gender = "Male",
            size = "Large",
            location = "Cobh, Cork",
            description = "A loyal and protective German Shepherd",
            image = ""
        ),
        Dog(
            id = "5",
            name = "Charlie",
            breed = "Irish Wolfhound",
            age = 5,
            gender = "Male",
            size = "Large",
            location = "Ballincollig, Cork",
            description = "A friendly and intelligent wolfhound",
            image = ""
        ),
        Dog(
            id = "6",
            name = "Molly",
            breed = "Jack Russell Terrier",
            age = 2,
            size = "Small",
            location = "Douglas, Cork",
            description = "A friendly and intelligent terrier",
            image = ""
        ),
        Dog(
            id = "7",
            name = "George",
            breed = "Collie",
            age = 3,
            gender = "Female",
            size = "Medium",
            location = "Ballincollig, Cork",
            description = "A friendly and intelligent collie",
            image = ""
        ),
        Dog(
            id = "8",
            name = "Luna",
            breed = "Labrador",
            age = 4,
            gender = "Female",
            size = "Medium",
            location = "Ballincollig, Cork",
            description = "A friendly Chocolate lab",
            image = ""
            )
    )
    fun getDog(id: String): Dog {
        return Dogs.first { it.id == id }
    }
}

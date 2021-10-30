package com.example.mycyberchallenge.models

class Book {
    var imageUrl: String = ""
    var id: Int = 0
    var author: String = ""
    var price: String = ""
    var isAvailable = true
    var description: String = ""
    var name: String = ""


    constructor(imageUrl: String, id: Int, author: String,price: String ,isAvailable: Boolean,
    description: String) {
        this.imageUrl = imageUrl
        this.id = id
        this.author = author
        this.price = price
        this.isAvailable = isAvailable
        this.description = description
    }

    constructor() {

    }
}
package com.example.mycyberchallenge.models

class Puzzle {
    var id: Int = 0
    var imageUrl: String = ""
    var price: String = ""

    constructor(id: Int, imageUrl: String, price: String) {
        this.id = id
        this.imageUrl = imageUrl
        this.price = price
    }

    constructor() {

    }
}
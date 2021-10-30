package com.example.mycyberchallenge.models

import android.media.Image

class Banner {
    var id: Int = 0
    var imageUrl: String = ""

    constructor(id: Int, imageUrl: String) {
        this.id = id
        this.imageUrl = imageUrl
    }

    constructor() {

    }
}
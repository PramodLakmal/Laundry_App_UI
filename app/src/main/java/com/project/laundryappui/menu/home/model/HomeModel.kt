package com.project.laundryappui.menu.home.model

class HomeModel {
    var image = 0
    var name: String? = null
    var price: String? = null
    var location: String? = null

    constructor()
    constructor(image: Int, name: String?, price: String?, location: String?) {
        this.image = image
        this.name = name
        this.price = price
        this.location = location
    }
}

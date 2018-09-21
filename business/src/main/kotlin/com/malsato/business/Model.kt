package com.malsato.business


import com.malsato.common.util.NoArgsConstructor
import java.util.*


abstract class BaseEntity(var id: UUID? = null)

@NoArgsConstructor
data class Restaurant(
        var name: String,
        var coordinates: Coordinates,
        var address: Address
) : BaseEntity()

@NoArgsConstructor
data class Coordinates(
        var lat: Double,
        var lng: Double
)

@NoArgsConstructor
data class Address(
        var street: String,
        var city: String,
        var zip: String
)

@NoArgsConstructor
data class Menu(
        var date: Date,
        var dishes: List<Dish>,
        var restaurant: Restaurant
) : BaseEntity()

@NoArgsConstructor
data class Dish(
        var name: String,
        var price: String,
        var description: String
) : BaseEntity()
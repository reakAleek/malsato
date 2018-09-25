package com.malsato.rest

import com.malsato.common.util.NoArgsConstructor
import java.time.LocalDate
import java.util.*

/**
 * @author Jan Calanog, jan.calanog@iteratec.at
 */

abstract class BaseEntity (var id: UUID? = null)

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
        var date: LocalDate,
        var dishes: List<Dish>,
        var restaurant: Restaurant
) : BaseEntity()

@NoArgsConstructor
data class Dish(
        var name: String,
        var price: String? = null,
        var description: String? = null
) : BaseEntity()
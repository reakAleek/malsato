package com.malsato.data.menu

import org.springframework.data.repository.CrudRepository
import java.time.LocalDate
import java.util.*

interface MenuRepository : CrudRepository<Menu, UUID> {

    fun findByRestaurantId(restaurantId: UUID): Iterable<Menu>

    fun findByRestaurantIdAndDate(restaurantId: UUID, date: LocalDate): Iterable<Menu>
}
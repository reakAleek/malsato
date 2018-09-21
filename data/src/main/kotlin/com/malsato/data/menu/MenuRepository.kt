package com.malsato.data.menu

import org.springframework.data.repository.CrudRepository
import java.util.*

interface MenuRepository : CrudRepository<Menu, UUID> {

    fun findByRestaurantId(restaurantId: UUID): Iterable<Menu>
}
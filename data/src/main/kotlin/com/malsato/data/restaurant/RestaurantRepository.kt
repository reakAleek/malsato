package com.malsato.data.restaurant

import org.springframework.data.repository.CrudRepository
import java.util.*

interface RestaurantRepository : CrudRepository<Restaurant, UUID>
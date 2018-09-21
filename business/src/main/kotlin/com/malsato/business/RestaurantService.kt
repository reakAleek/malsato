package com.malsato.business

import com.malsato.data.restaurant.RestaurantRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*
import javax.persistence.EntityManager

@Service
class RestaurantService(
        @Autowired val restaurantRepository: RestaurantRepository,
        @Autowired val entityManager: EntityManager,
        @Autowired val mapper: ModelMapper
) {

    @Transactional(readOnly = true)
    fun getAllRestaurants(): List<Restaurant> {
        val restaurants = restaurantRepository.findAll()
        return restaurants.map { restaurant -> mapper.map(restaurant, Restaurant::class.java) }
    }

    @Transactional(readOnly = true)
    fun getRestaurant(id: String): Restaurant {
        return getRestaurant(UUID.fromString(id))
    }

    @Transactional(readOnly = true)
    fun getRestaurant(id: UUID): Restaurant {
        val dataRestaurant = restaurantRepository.findById(id)
                .orElseThrow { IllegalArgumentException("Unable to find Restaurant with the id $id.") }
        return mapper.map(dataRestaurant, Restaurant::class.java)
    }

    @Transactional
    fun deleteRestaurant(id: UUID) {
        restaurantRepository.deleteById(id)
    }

    @Transactional
    fun createRestaurant(restaurant: Restaurant): Restaurant {
        val dataRestaurant = mapper.map(restaurant, com.malsato.data.restaurant.Restaurant::class.java)
        val managedRestaurant = restaurantRepository.save(dataRestaurant)
        return mapper.map(managedRestaurant, Restaurant::class.java)
    }
}
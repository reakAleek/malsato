package com.malsato.rest.restaurant

import com.malsato.business.RestaurantService
import com.malsato.rest.Restaurant
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 * @author Jan Calanog, jan.calanog@iteratec.at
 */
@RestController
@RequestMapping("restaurants")
class RestaurantController(
        @Autowired val restaurantService: RestaurantService,
        @Autowired val modelMapper: ModelMapper
) {
    @GetMapping("")
    fun getRestaurants(): List<Restaurant> {
        return restaurantService.getAllRestaurants().map { modelMapper.map(it, Restaurant::class.java) }
    }

    @PostMapping("")
    fun createRestaurant(@RequestBody restaurant: Restaurant): Restaurant {
        val businessRestaurant = modelMapper.map(restaurant, com.malsato.business.Restaurant::class.java)
        return modelMapper.map(restaurantService.createRestaurant(businessRestaurant), Restaurant::class.java)
    }

    @GetMapping("/{id}")
    fun getRestaurant(@PathVariable id: UUID): Restaurant {
        val restaurant = restaurantService.getRestaurant(id)
        return modelMapper.map(restaurant, Restaurant::class.java)
    }
}
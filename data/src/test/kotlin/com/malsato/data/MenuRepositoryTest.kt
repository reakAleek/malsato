package com.malsato.data

import assertk.assert
import assertk.assertions.*
import com.malsato.data.dish.Dish
import com.malsato.data.menu.Menu
import com.malsato.data.menu.MenuRepository
import com.malsato.data.restaurant.Restaurant
import com.malsato.data.restaurant.RestaurantRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*
import javax.persistence.EntityManager

@RunWith(SpringRunner::class)
@SpringBootTest
class MenuRepositoryTest {

    @SpringBootApplication
    class TestApp

    @Autowired
    lateinit var restaurantRepository: RestaurantRepository

    @Autowired
    lateinit var entityManager: EntityManager

    @Autowired
    lateinit var menuRepository: MenuRepository

    @Test
    fun hello_world() {

        val restaurant = Restaurant(
                "Saturn Lounge",
                48.23635,
                16.41314,
                "Wien",
                "1220",
                "Leonard-Bernstein-Straße 10"
        )

        restaurantRepository.save(restaurant)

        val dish1 = Dish("Schnitzel", "€ 6,90", "Mit Kartoffelsalat \n und whatever")
        val dish2 = Dish("Gulasch", "€ 6,90", "Mit Semmel")

        val menu = Menu(Date(), listOf(dish1, dish2), restaurant)

        menuRepository.save(menu)

        val _menu = menuRepository.findById(menu.id!!)
        assert(menuRepository.findByRestaurantId(restaurant.id!!).count()).isGreaterThan(0)
        assert(_menu.get().dishes).hasSize(2)

        assert(restaurantRepository.findAll().count()).isNotZero()
    }
}
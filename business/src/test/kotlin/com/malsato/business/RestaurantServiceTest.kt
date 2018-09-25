package com.malsato.business

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import assertk.assert
import assertk.assertions.*
import com.malsato.business.config.BusinessModuleConfiguration
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import java.time.LocalDate
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class RestaurantServiceTest {

    @Autowired
    lateinit var restaurantService: RestaurantService

    @Autowired
    lateinit var menuService: MenuService

    @SpringBootApplication
    class TestApp

    @Test
    fun hello_world() {

        val coordinates = Coordinates(48.23635, 16.41314)
        val address = Address("Leonard-Bernstein-Straße 10", "1220", "Wien")
        val toBeCreatedRestaurant = Restaurant("Saturn Lounge", coordinates, address)

        val createdRestaurant = restaurantService.createRestaurant(toBeCreatedRestaurant)

        assert { restaurantService.getRestaurant(createdRestaurant.id!!) }.doesNotThrowAnyException()

        assert(createdRestaurant.name).isNotEmpty()
        assert(createdRestaurant.address).isNotNull()
        assert(createdRestaurant.address.city).isNotEmpty()
        assert(createdRestaurant.address.zip).isNotEmpty()
        assert(createdRestaurant.address.street).isNotEmpty()
        assert(createdRestaurant.coordinates).isNotNull()


        restaurantService.deleteRestaurant(createdRestaurant.id!!)

        assert { restaurantService.getRestaurant(createdRestaurant.id!!) }.thrownError {
            hasClass(IllegalArgumentException::class)
        }
    }

    @Test
    fun deleteRestaurant_validId_deleteRestaurantAndMenusFromRestaurant() {
        // Arrange
        val coordinates = Coordinates(48.23635, 16.41314)
        val address = Address("Leonard-Bernstein-Straße 10", "1220", "Wien")
        val toBeCreatedRestaurant = Restaurant("Saturn Lounge", coordinates, address)
        val createdRestaurant = restaurantService.createRestaurant(toBeCreatedRestaurant)
        val dish1 = Dish("Schnitzel", "€ 7,50", "Mit Kartoffelsalat")
        val dish2 = Dish("Gulasch", "€ 5,80", "Mit Gebäck")
        val date = LocalDate.now().plusDays(1)
        val menu = Menu(date, listOf(dish1, dish2), createdRestaurant)
        menuService.createMenu(menu)
        val menus = menuService.getMenus(createdRestaurant.id!!, date)
        assert(menus.size).isGreaterThan(0)

        // Act
        restaurantService.deleteRestaurant(createdRestaurant.id!!)

        // Assert
        val menusAfterDeletingRestaurant = menuService.getMenus(createdRestaurant.id!!, date)
        assert(menusAfterDeletingRestaurant).isEmpty()
    }
}
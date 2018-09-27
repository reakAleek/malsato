package com.malsato.data

import assertk.assert
import assertk.assertions.isEqualTo
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
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import javax.persistence.EntityManager

/**
 * @author Jan Calanog, jan.calanog@iteratec.at
 */
@RunWith(SpringRunner::class)
@SpringBootTest
class RestaurantRepositoryTest {

    @SpringBootApplication
    class TestApp

    @Autowired
    lateinit var restaurantRepository: RestaurantRepository

    @Autowired
    lateinit var menuRepository: MenuRepository

    @Test
    @Transactional
    fun deleteRestaurant_validId_shouldAlsoDeleteMenusOfGivenRestaurant() {
        // Arrange
        val restaurant = Restaurant(
                "UP",
                48.23206,
                16.413688,
                "Wien",
                "1220",
                "Donau-City-Strasse 7"
        )
        restaurantRepository.save(restaurant)

        val dish1 = Dish("Schnitzel", "€ 6,90", "Mit Kartoffelsalat \n und whatever")
        val dish2 = Dish("Gulasch", "€ 6,90", "Mit Semmel")
        val dish3 = Dish("Schnitzel", "€ 6,90", "Mit Kartoffelsalat \n und whatever")
        val dish4 = Dish("Gulasch", "€ 6,90", "Mit Semmel")
        val menu = Menu(LocalDate.now(), listOf(dish1, dish2), restaurant)
        val menu2 = Menu(LocalDate.now(), listOf(dish3, dish4), restaurant)
        menuRepository.saveAll(listOf(menu, menu2))
        val _menus = menuRepository.findByRestaurantId(restaurant.id!!)
        assert(_menus.count()).isEqualTo(2)

        // Act
        restaurantRepository.delete(restaurant)

        // Assert
        val menus = menuRepository.findByRestaurantId(restaurant.id!!)
        assert(menus.count()).isEqualTo(0)
    }
}
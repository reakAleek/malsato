package com.malsato.data

import assertk.assert
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import assertk.assertions.isGreaterThan
import assertk.assertions.isNotZero
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
import java.time.LocalDate

/**
 * @author Jan Calanog, jan.calanog@iteratec.at
 */
@RunWith(SpringRunner::class)
@SpringBootTest
class MenuRepositoryTest {


    @SpringBootApplication
    class TestApp

    @Autowired
    lateinit var restaurantRepository: RestaurantRepository

    @Autowired
    lateinit var menuRepository: MenuRepository

    @Test
    fun creatingMenus_validData_shouldBeFoundByRestaurantIdAndHaveDishes() {
        // Arrange
        val restaurant = Restaurant(
                "Saturn Lounge",
                48.23635,
                16.41314,
                "Wien",
                "1220",
                "Leonard-Bernstein-Straße 10"
        )
        restaurantRepository.save(restaurant)

        // Act
        val dish1 = Dish("Schnitzel", "€ 6,90", "Mit Kartoffelsalat \n und whatever")
        val dish2 = Dish("Gulasch", "€ 6,90", "Mit Semmel")
        val dish3 = Dish("Schnitzel", "€ 6,90", "Mit Kartoffelsalat \n und whatever")
        val menu = Menu(LocalDate.now(), listOf(dish1, dish2), restaurant)
        val menu2 = Menu(LocalDate.now(), listOf(dish3), restaurant)
        menuRepository.saveAll(listOf(menu, menu2))

        // Assert
        assert(menuRepository.findByRestaurantId(restaurant.id!!).count()).isEqualTo(2)
        assert(menuRepository.findById(menu.id!!).get().dishes.count()).isEqualTo(2)
    }
}
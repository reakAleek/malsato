package com.malsato.business

import com.malsato.data.menu.MenuRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*
import javax.persistence.EntityManager

@Service
class MenuService(
        @Autowired val menuRepository: MenuRepository,
        @Autowired val entityManager: EntityManager,
        @Autowired val mapper: ModelMapper
) {
    fun getMenus(): List<Menu> {
        val menus = menuRepository.findAll()
        return menus.map { menu -> mapper.map(menu, Menu::class.java) }
    }

    fun getMenus(restaurantId: UUID, date: LocalDate): List<Menu> {
        val menus = menuRepository.findByRestaurantIdAndDate(restaurantId, date)
        return menus.map { menu -> mapper.map(menu, Menu::class.java) }
    }

    fun createMenu(menu: Menu): Menu {
        val dataMenu = mapper.map(menu, com.malsato.data.menu.Menu::class.java)
        val managedMenu = menuRepository.save(dataMenu)
        return mapper.map(managedMenu, Menu::class.java)
    }
}
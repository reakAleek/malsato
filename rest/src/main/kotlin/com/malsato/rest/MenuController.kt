package com.malsato.rest

import com.malsato.business.Menu
import com.malsato.business.MenuService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("menus")
class MenuController(
        @Autowired val menuService: MenuService
) {

    @GetMapping("")
    fun getMenus(): List<Menu> {

        return menuService.getAllMenus()
    }
}
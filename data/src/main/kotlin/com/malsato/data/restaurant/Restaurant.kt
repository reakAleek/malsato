package com.malsato.data.restaurant

import com.malsato.data.BaseEntity
import com.malsato.data.menu.Menu
import javax.persistence.*


@Entity
data class Restaurant (

        @Column(nullable = false)
        var name: String,

        @Column(name = "coordinates_lat")
        var coordinatesLat: Double,

        @Column(name = "coordinates_lng")
        var coordinatesLng: Double,

        @Column(name = "address_city")
        var addressCity: String,

        @Column(name = "address_zip")
        var addressZip: String,

        @Column(name = "address_street")
        var addressStreet: String,

        @OneToMany(mappedBy = "restaurant", orphanRemoval = true, fetch = FetchType.LAZY)
        private var menus: Collection<Menu> = emptyList()
) : BaseEntity()
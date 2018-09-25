package com.malsato.data.restaurant

import com.malsato.data.BaseEntity
import com.malsato.data.menu.Menu
import javax.persistence.*


@Entity
data class Restaurant (

        @Column(nullable = false)
        var name: String,

        @Column(name = "coordinates_lat", nullable = false)
        var coordinatesLat: Double,

        @Column(name = "coordinates_lng", nullable = false)
        var coordinatesLng: Double,

        @Column(name = "address_city", nullable = false)
        var addressCity: String,

        @Column(name = "address_zip", nullable = false)
        var addressZip: String,

        @Column(name = "address_street", nullable = false)
        var addressStreet: String,

        @OneToMany(
                mappedBy = "restaurant",
                orphanRemoval = true,
                fetch = FetchType.LAZY
        )
        private var menus: Collection<Menu> = emptyList()
) : BaseEntity()
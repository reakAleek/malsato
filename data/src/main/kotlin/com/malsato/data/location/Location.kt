package com.malsato.data.location

import com.malsato.data.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class Location (
        val name: String,

        @Column(name = "is_active")
        val isActive: Boolean,

        @Column(name = "radius_in_meter")
        val radiusInMeter: Int,

        @Column(name = "coordinates_lat")
        val coordinatesLat: Double,

        @Column(name = "coordinates_lng")
        val coordinatesLng: Double
) : BaseEntity()
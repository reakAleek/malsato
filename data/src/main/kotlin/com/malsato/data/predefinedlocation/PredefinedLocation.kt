package com.malsato.data.predefinedlocation

import com.malsato.data.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class PredefinedLocation (
        @Column(nullable = false)
        var name: String,

        @Column(name = "is_active", nullable = false)
        var isActive: Boolean = false,

        @Column(name = "radius_in_meter", nullable = false)
        var radiusInMeter: Int,

        @Column(name = "coordinates_lat", nullable = false)
        var coordinatesLat: Double,

        @Column(name = "coordinates_lng", nullable = false)
        var coordinatesLng: Double
) : BaseEntity()
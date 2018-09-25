package com.malsato.data.menu

import com.malsato.data.BaseEntity
import com.malsato.data.dish.Dish
import com.malsato.data.restaurant.Restaurant
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import org.springframework.data.jpa.repository.Temporal
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
data class Menu (
        @Column(nullable = false)
        var date: LocalDate,

        @OneToMany(
                cascade = [CascadeType.ALL],
                orphanRemoval = true,
                fetch = FetchType.EAGER
        )
        @JoinColumn(name = "menu_id", nullable = false)
        var dishes: List<Dish>,

        @ManyToOne
        var restaurant: Restaurant
) : BaseEntity()
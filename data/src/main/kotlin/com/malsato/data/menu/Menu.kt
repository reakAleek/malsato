package com.malsato.data.menu

import com.malsato.data.BaseEntity
import com.malsato.data.dish.Dish
import com.malsato.data.restaurant.Restaurant
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import org.springframework.data.jpa.repository.Temporal
import java.util.*
import javax.persistence.*

@Entity
data class Menu (
        @Temporal(TemporalType.DATE)
        @Column(nullable = false)
        val date: Date,

        @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.EAGER)
        @JoinColumn(name = "menu_id")
        val dishes: List<Dish>,

        @ManyToOne
        val restaurant: Restaurant
) : BaseEntity()
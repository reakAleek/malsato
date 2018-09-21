package com.malsato.data.dish

import com.malsato.data.BaseEntity
import com.malsato.data.menu.Menu
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
data class Dish (
        val name: String,
        val price: String,
        val description: String
) : BaseEntity()
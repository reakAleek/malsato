package com.malsato.data.dish

import com.malsato.data.BaseEntity
import com.malsato.data.menu.Menu
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
data class Dish (
        var name: String,
        var price: String? = null,
        var description: String? = null
) : BaseEntity()
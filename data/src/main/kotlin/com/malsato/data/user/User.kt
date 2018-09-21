package com.malsato.data.user
import com.malsato.data.BaseEntity
import java.util.*
import javax.persistence.*

@Entity
data class User (
        @Column(nullable = false)
        val name: String,

        @Column(nullable = false, unique = true)
        val email: String,

        @Temporal(TemporalType.DATE)
        val birthday: Date,

        @Column(name = "is_admin", nullable = false)
        val isAdmin: Boolean
) : BaseEntity()
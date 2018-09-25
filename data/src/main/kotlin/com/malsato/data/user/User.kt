package com.malsato.data.user
import com.malsato.data.BaseEntity
import java.util.*
import javax.persistence.*

@Entity
data class User (
        @Column(nullable = false)
        var name: String,

        @Column(nullable = false, unique = true)
        var email: String,

        @Temporal(TemporalType.DATE)
        var birthday: Date,

        @Column(name = "is_admin", nullable = false)
        var isAdmin: Boolean
) : BaseEntity()
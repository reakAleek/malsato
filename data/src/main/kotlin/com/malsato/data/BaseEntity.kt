package com.malsato.data

import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@MappedSuperclass
abstract class BaseEntity (
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(columnDefinition = "BINARY(16)")
        var id: UUID? = null,

        @LastModifiedDate
        @Column(name = "created_at", nullable = false)
        var createdAt: LocalDateTime? = null,

        @CreatedDate
        @Column(name = "updated_at", nullable = false, updatable = false)
        var updatedAt: LocalDateTime? = null
) {
    @PrePersist
    fun prePersist() {
        createdAt = LocalDateTime.now()
        updatedAt = LocalDateTime.now()
    }

    @PreUpdate
    fun preUpddate() {
        updatedAt = LocalDateTime.now()
    }
}

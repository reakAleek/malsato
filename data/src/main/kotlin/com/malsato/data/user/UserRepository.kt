package com.malsato.data.user

import org.springframework.data.repository.CrudRepository


interface UserRepository : CrudRepository<User, Long>
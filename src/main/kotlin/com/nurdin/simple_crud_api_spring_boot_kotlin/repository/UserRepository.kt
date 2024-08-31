package com.nurdin.simple_crud_api_spring_boot_kotlin.repository

import com.nurdin.simple_crud_api_spring_boot_kotlin.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>
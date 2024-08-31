package com.nurdin.simple_crud_api_spring_boot_kotlin.service

import com.nurdin.simple_crud_api_spring_boot_kotlin.dto.UserDto

interface UserService {
    fun getAllUsers(): List<UserDto>
    fun getUserById(id: Long): UserDto
    fun createUser(userDto: UserDto): UserDto
    fun updateUser(id: Long, userDto: UserDto): UserDto
    fun deletUser(id: Long)
}
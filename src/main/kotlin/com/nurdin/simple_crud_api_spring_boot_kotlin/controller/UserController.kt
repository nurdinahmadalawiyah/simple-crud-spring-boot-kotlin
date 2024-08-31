package com.nurdin.simple_crud_api_spring_boot_kotlin.controller

import com.nurdin.simple_crud_api_spring_boot_kotlin.dto.UserDto
import com.nurdin.simple_crud_api_spring_boot_kotlin.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {
    @GetMapping
    fun getAllUsers(): List<UserDto> = userService.getAllUsers();

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): UserDto = userService.getUserById(id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody userDto: UserDto): UserDto = userService.createUser(userDto)

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userDto: UserDto): UserDto = userService.updateUser(id, userDto)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Long) = userService.deletUser(id)
}
package com.nurdin.simple_crud_api_spring_boot_kotlin.service

import com.nurdin.simple_crud_api_spring_boot_kotlin.dto.UserDto
import com.nurdin.simple_crud_api_spring_boot_kotlin.model.User
import com.nurdin.simple_crud_api_spring_boot_kotlin.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun getAllUsers(): List<UserDto> =
        userRepository.findAll().map { it.toDto() }

    override fun getUserById(id: Long): UserDto =
        userRepository.findByIdOrNull(id)?.toDto()
            ?: throw NoSuchElementException("User not found with id $id")

    override fun createUser(userDto: UserDto): UserDto =
        userRepository.save(User(name = userDto.name, email = userDto.email)).toDto()

    override fun updateUser(id: Long, userDto: UserDto): UserDto {
        val existingUser = userRepository.findByIdOrNull(id)
            ?: throw NoSuchElementException("User not found with id $id")

        existingUser.name = userDto.name
        existingUser.email = userDto.email

        return userRepository.save(existingUser).toDto()
    }

    override fun deletUser(id: Long) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
        } else {
            throw NoSuchElementException("User not found with id $id")
        }
    }

    private fun User.toDto(): UserDto = UserDto(id, name, email)

}
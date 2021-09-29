package ultra.chat.backend.repository

import org.springframework.data.jpa.repository.JpaRepository
import ultra.chat.backend.entity.User

interface IUserRepository: JpaRepository<User, Int> {

    fun findByEmail(email: String): User?
}
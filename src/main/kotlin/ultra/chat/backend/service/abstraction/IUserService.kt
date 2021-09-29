package ultra.chat.backend.service.abstraction

import ultra.chat.backend.entity.User

interface IUserService {

    fun getUserByEmail(email: String): User?

    fun getAll(): List<User>
}
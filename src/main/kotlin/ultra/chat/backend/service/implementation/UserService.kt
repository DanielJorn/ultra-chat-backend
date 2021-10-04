package ultra.chat.backend.service.implementation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ultra.chat.backend.entity.User
import ultra.chat.backend.repository.IUserRepository
import ultra.chat.backend.service.abstraction.IUserService

@Service
class UserService @Autowired constructor(
    private val userRepository: IUserRepository
) : IUserService {

    override fun getUserByEmail(email: String): User? = userRepository.findByEmail(email)

    override fun getAll(): List<User> = userRepository.findAll()
}
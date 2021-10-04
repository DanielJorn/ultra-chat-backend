package ultra.chat.backend.service.implementation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ultra.chat.backend.entity.User
import ultra.chat.backend.model.Account
import ultra.chat.backend.repository.IUserRepository

@Service
class AccountService @Autowired constructor(
    private val userRepository: IUserRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        if (username == null) {
            throw UsernameNotFoundException("$username not found")
        }
        val user: User = userRepository.findByEmail(username) ?: throw UsernameNotFoundException("$username not found")
        return Account(user)
    }
}
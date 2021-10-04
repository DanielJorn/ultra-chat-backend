package ultra.chat.backend.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ultra.chat.backend.entity.User
import ultra.chat.backend.handler.abstraction.IJwtHandler
import ultra.chat.backend.model.AuthRequest
import ultra.chat.backend.service.abstraction.IUserService

@RestController
@RequestMapping("/api/auth")
class AuthController @Autowired constructor(
    private val userService: IUserService,
    private val jwtHandler: IJwtHandler,
    private val passwordEncoder: PasswordEncoder
) {

    @PostMapping("/sign-in")
    fun signIn(@RequestBody authRequest: AuthRequest): String {
        val user: User? = userService.getUserByEmail(authRequest.email)

        if (user == null || !passwordEncoder.matches(authRequest.password, user.password)) {
            throw UsernameNotFoundException("${authRequest.email} not found")
        }

        return jwtHandler.generateToken(user.email)
    }
}
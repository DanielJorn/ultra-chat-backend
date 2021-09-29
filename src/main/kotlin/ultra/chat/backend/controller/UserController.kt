package ultra.chat.backend.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ultra.chat.backend.entity.User
import ultra.chat.backend.service.abstraction.IUserService

@RestController
@RequestMapping("/api/users")
class UserController @Autowired constructor(
    private val userService: IUserService
) {

    @GetMapping("")
    fun getAllUsers(): List<User> = userService.getAll()
}
package ultra.chat.backend.handler.abstraction

interface IJwtHandler {

    fun generateToken(email: String): String

    fun validateToken(token: String): Boolean

    fun getEmailFromToken(token: String): String
}
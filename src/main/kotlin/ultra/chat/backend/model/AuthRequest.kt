package ultra.chat.backend.model

data class AuthRequest(
    val email: String,
    val password: String
)
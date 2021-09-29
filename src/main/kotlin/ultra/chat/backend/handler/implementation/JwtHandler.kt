package ultra.chat.backend.handler.implementation

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import ultra.chat.backend.handler.abstraction.IJwtHandler
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

@Component
class JwtHandler: IJwtHandler {

    companion object {
        private const val JWT_SECRET: String = "jwt_secret"
    }

    override fun generateToken(email: String): String = Jwts.builder()
        .setSubject(email)
        .setExpiration(Date.from(LocalDateTime.now().plusYears(10).atZone(ZoneId.systemDefault()).toInstant()))
        .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
        .compact()

    override fun validateToken(token: String): Boolean = try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token)
            true
        } catch (exception: Exception) {
            false
        }

    override fun getEmailFromToken(token: String): String = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).body.subject
}
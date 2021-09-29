package ultra.chat.backend.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import org.springframework.web.filter.GenericFilterBean
import ultra.chat.backend.handler.abstraction.IJwtHandler
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

@Component
class JwtFilter @Autowired constructor(
    private val jwtHandler: IJwtHandler,
    private val userDetailsService: UserDetailsService): GenericFilterBean() {

    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }

    override fun doFilter(servletRequest: ServletRequest?, servletResponse: ServletResponse?, filterChain: FilterChain?) {
        val token: String? = getTokenFromRequest(servletRequest as HttpServletRequest)
        println("token: $token")
        if (token != null && jwtHandler.validateToken(token)) {
            val email: String = jwtHandler.getEmailFromToken(token)
            println("email: $email")
            val userDetails: UserDetails = userDetailsService.loadUserByUsername(email)
            println("userDetails: ${userDetails.password}")
            val auth = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
            SecurityContextHolder.getContext().authentication = auth
        }
        filterChain?.doFilter(servletRequest, servletResponse)
    }

    private fun getTokenFromRequest(request: HttpServletRequest): String? {
        val bearer = request.getHeader(AUTHORIZATION_HEADER) ?: return null
        if (bearer.isNotEmpty() && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null
    }
}
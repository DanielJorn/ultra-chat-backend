package ultra.chat.backend.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import ultra.chat.backend.entity.User

class Account(private val user: User): UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = mutableListOf(Authority())

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}
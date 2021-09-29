package ultra.chat.backend.model

import org.springframework.security.core.GrantedAuthority

class Authority: GrantedAuthority {
    override fun getAuthority(): String = "user"
}
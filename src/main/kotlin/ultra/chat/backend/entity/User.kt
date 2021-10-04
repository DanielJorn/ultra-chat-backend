package ultra.chat.backend.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class User {

    @Id
    @Column(name = "id")
    val id: Int = 0

    @Column(name = "email")
    val email: String = ""

    @Column(name = "password")
    val password: String = ""
}
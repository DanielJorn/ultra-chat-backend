package ultra.chat.backend.entity

import javax.persistence.*

@Entity
@Table(name = "users")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0

    @Column(name = "email")
    val email: String = ""

    @Column(name = "password")
    val password: String = ""

    @Column(name = "first_name")
    val firstName: String = ""

    @Column(name = "second_name")
    val secondName: String = ""
}
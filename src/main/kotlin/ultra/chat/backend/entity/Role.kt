package ultra.chat.backend.entity

import javax.persistence.*

@Entity
@Table(name = "roles")
class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long  = 0

    @Column(name = "title")
    val title: String = ""
}
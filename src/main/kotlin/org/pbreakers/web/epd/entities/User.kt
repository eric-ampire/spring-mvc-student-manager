package org.pbreakers.web.epd.entities

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class User(
    @Id val id: String,
    val nom: String,
    val postnom: String,
    val prenom: String,
    val username: String,
    val password: String
)
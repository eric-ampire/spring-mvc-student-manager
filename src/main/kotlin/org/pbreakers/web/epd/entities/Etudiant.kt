package org.pbreakers.web.epd.entities

import java.io.Serializable
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Etudiant(
    @Id @GeneratedValue val id: Long,
    val nom: String,
    val dateNaissance: Date,
    val email: String,
    val photo: String
) : Serializable
package org.pbreakers.web.epd.dao

import org.pbreakers.web.epd.entities.Etudiant
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface EtudiantRepository : JpaRepository<Etudiant, Long> {
    fun findByNom(nom: String): List<Etudiant>
    fun findByNom(nom: String, pageable: Pageable): Page<Etudiant>

    @Query("SELECT e from Etudiant e where e.nom like :x")
    fun chercherEtudiant(@Param("x") mc: String, pageable: Pageable): Page<Etudiant>

    @Query("SELECT e from Etudiant e where e.dateNaissance > :debut and e.dateNaissance < :fin")
    fun chercherEtudiant(@Param("debut") dateDebut: Date, @Param("fin") dateFin: Date): List<Etudiant>
}
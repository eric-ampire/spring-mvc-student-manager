package org.pbreakers.web.epd.dao

import org.pbreakers.web.epd.entities.Etudiant
import org.springframework.data.jpa.repository.JpaRepository

interface EtudiantRepository : JpaRepository<Etudiant, Long>
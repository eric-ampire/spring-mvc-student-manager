package org.pbreakers.web.epd.dao

import org.pbreakers.web.epd.entities.Etudiant
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import java.util.*

interface EtudiantRepository : PagingAndSortingRepository<Etudiant, Long> {

}
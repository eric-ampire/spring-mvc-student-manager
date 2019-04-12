package org.pbreakers.web.epd

import org.pbreakers.web.epd.dao.EtudiantRepository
import org.pbreakers.web.epd.entities.Etudiant
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.domain.PageRequest
import java.text.SimpleDateFormat
import java.util.*

@SpringBootApplication
class SpringDemoApplication

fun main(args: Array<String>) {
	runApplication<SpringDemoApplication>(*args)
}

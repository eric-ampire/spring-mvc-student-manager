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
	val ctx = runApplication<SpringDemoApplication>(*args)
	val etudiantRepository = ctx.getBean(EtudiantRepository::class.java)

	for (a in 1..30) {
		val a = Etudiant(a.toLong(), "Eric Ampire $a", Date(), "eric$a@gmail.com", "photo$a.jpg")
		etudiantRepository.save(a)
	}
}

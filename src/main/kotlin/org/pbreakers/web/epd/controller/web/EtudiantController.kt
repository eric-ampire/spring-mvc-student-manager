package org.pbreakers.web.epd.controller.web

import org.pbreakers.web.epd.dao.EtudiantRepository
import org.pbreakers.web.epd.entities.Etudiant
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
class EtudiantController {

    @Autowired
    private lateinit var etudiantRepository: EtudiantRepository


    // Pour acceder a ce l'index il faut utiliser l'url "localhost:port/etudiants/index"
    @RequestMapping("/")
    fun index(model: Model,
              @RequestParam(name = "page", defaultValue = "0") page: Int,
              @RequestParam(name = "motCle", defaultValue = "") motCles: String): String {

        // Get page of student
        val pageEtudiants: Page<Etudiant> = etudiantRepository.findAll(PageRequest.of(page, 4))

        // List content the number of each page
        val pagesNumber = (0 until pageEtudiants.totalPages).toList()


        model["pageEtudiants"] = pageEtudiants
        model["pageNumber"] =  pagesNumber
        model["currentPage"] = page
        model["mc"] = motCles
        return "index"
    }

    @RequestMapping("/form")
    fun showForm(model: Model): String {
        model["etudiant"] = Etudiant()
        return "form"
    }

    @PostMapping("/saveEtudiant")
    fun save(etudiant: Etudiant): String {
        etudiantRepository.save(etudiant)
        return "redirect:/"
    }
}
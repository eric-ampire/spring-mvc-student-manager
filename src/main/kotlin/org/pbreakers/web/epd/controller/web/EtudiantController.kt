package org.pbreakers.web.epd.controller.web

import org.pbreakers.web.epd.dao.EtudiantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/etudiants")
class EtudiantController {

    @Autowired
    private lateinit var etudiantRepository: EtudiantRepository


    // Pour acceder a ce l'index il faut utiliser l'url "localhost:port/etudiants/index"
    @RequestMapping("/index")
    fun index(model: Model,
              @RequestParam(name = "page", defaultValue = "0") page: Int,
              @RequestParam(name = "motCle", defaultValue = "") motCles: String): String {

        // Get page of student
        val pageEtudiants = etudiantRepository.chercherEtudiant("%$motCles%", PageRequest(page, 4))

        // List content the number of each page
        val pagesNumber = (1 until pageEtudiants.totalPages).toList()

        // Avant de retourner la vue, on ajoute les informations dans le model
        // comme ca ces information serons disponible dans la vue
        model.addAttribute("pageEtudiants", pageEtudiants)
        model.addAttribute("pageNumber", pagesNumber)
        model.addAttribute("currentPage", page)
        model.addAttribute("mc", motCles)
        return "index"
    }

    @RequestMapping("/form")
    fun showForm(): String {
        return "form"
    }
}
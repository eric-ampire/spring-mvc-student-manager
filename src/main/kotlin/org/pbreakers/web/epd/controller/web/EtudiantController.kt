package org.pbreakers.web.epd.controller.web

import org.pbreakers.web.epd.dao.EtudiantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/etudiants")
class EtudiantController {

    @Autowired
    private lateinit var etudiantRepository: EtudiantRepository


    // Pour acceder a ce l'index il faut utiliser l'url "localhost:port/etudiants/index"
    @RequestMapping("/index")
    fun index(model: Model): String {
        val etudiants = etudiantRepository.findAll()

        // Avant de retourner la vue, on ajoute les informations dans le model
        // comme ca ces information serons disponible dans la vue
        model.addAttribute("etudiants", etudiants)
        return "index"
    }
}
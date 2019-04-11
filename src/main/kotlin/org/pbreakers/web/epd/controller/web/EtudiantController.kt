package org.pbreakers.web.epd.controller.web

import org.pbreakers.web.epd.dao.EtudiantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class EtudiantController {

    @Autowired
    private lateinit var etudiantRepository: EtudiantRepository

    @RequestMapping("/")
    fun index(): String {
        return "index"
    }
}
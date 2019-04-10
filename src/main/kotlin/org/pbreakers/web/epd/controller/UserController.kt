package org.pbreakers.web.epd.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class UserController {

    @GetMapping("/")
    fun index(): String {
        return "page/home"
    }

    @GetMapping("/loginView")
    fun loginView(): String {
        return "page/login"
    }

    @GetMapping("/createAccountView")
    fun createAccount(): String {
        return "page/createAccount"
    }
}
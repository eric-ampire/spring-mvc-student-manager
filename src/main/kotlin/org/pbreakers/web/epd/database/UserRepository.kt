package org.pbreakers.web.epd.database

import org.pbreakers.web.epd.entities.User
import org.springframework.data.repository.CrudRepository

abstract class UserRepository : CrudRepository<String, User>
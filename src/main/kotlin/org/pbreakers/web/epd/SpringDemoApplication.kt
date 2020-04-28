package org.pbreakers.web.epd

import com.elbekD.bot.Bot
import org.pbreakers.web.epd.Message.GDG_ABOUT_MESSAGE_EN
import org.pbreakers.web.epd.Message.GDG_ABOUT_MESSAGE_FR
import org.pbreakers.web.epd.Message.POLICY_MESSAGE_EN
import org.pbreakers.web.epd.Message.POLICY_MESSAGE_FR
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

	val token = "1162565503:AAGMDR97qHJAaVsDetB2CVqLJb9ZB5tIvbU"
	val username = "@gdg_assistant_bot"

	Bot.createPolling(username, token).apply {
		setBotCommandListener(this)
		start()
	}
}

private fun setBotCommandListener(bot: Bot) {
	bot.run {
		onCommand("/start") { msg, _ ->
			bot.sendMessage(msg.chat.id, "Hey ${msg.chat.first_name} ${msg.chat.last_name}")
		}

		onCommand("/gdg_policy_en") { msg, _ -> bot.sendMessage(msg.chat.id, POLICY_MESSAGE_EN) }
		onCommand("/gdg_policy_fr") { msg, _ -> bot.sendMessage(msg.chat.id, POLICY_MESSAGE_FR) }
		onCommand("/gdg_about_en") { msg, _ -> bot.sendMessage(msg.chat.id, GDG_ABOUT_MESSAGE_EN) }
		onCommand("/gdg_about_fr") { msg, _ -> bot.sendMessage(msg.chat.id, GDG_ABOUT_MESSAGE_FR) }
	}
}

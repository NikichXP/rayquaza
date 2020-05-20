package com.nikichxp.rayquaza.mythic

import com.fasterxml.jackson.databind.ObjectMapper
import com.nikichxp.rayquaza.io.raider.RIOProvider
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import javax.annotation.PostConstruct


@Component
class RunsProvider(
		private val rioProvider: RIOProvider) {

	private val restTemplate = RestTemplate()
	private val mapper = ObjectMapper()

	private val url = "https://raider.io/api/v1/mythic-plus/runs?season=season-7.3.0&region=world&dungeon=all"

	@PostConstruct
	fun init() {
		val str = rioProvider.getRuns()
		println(str)
	}

}

data class MythicResult(var rankings: List<String>) {

}
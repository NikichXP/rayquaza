package com.nikichxp.rayquaza.io.raider

import org.springframework.stereotype.Service

@Service
class RIOProvider {

	fun getRuns(): String {
		val args = mapOf(
				"season" to RIOSeason.BFA_4.value,
				"region" to "world",
				"dungeon" to "all"
		)
		val someResult = executeRequest(RIOMethod.MYTHIC_PLUS_RUNS.value + "?" + createArgsLine(args))
		return executeRequest("mythic-plus/runs?season=season-7.3.0&region=world&dungeon=all")
	}

	fun createArgsLine(args: Map<String, String>) = args.map { "${it.key}=${it.value}" }.joinToString(separator = "&")

	// mythic-plus/runs?season=season-7.3.0&region=world&dungeon=all
	private fun executeRequest(method: String) = Runtime.getRuntime()
			.exec("curl -X GET \"$API_GATEWAY$method\"")
			.inputStream.reader().readText()

	companion object {
		private const val API_GATEWAY = "https://raider.io/api/v1/"
	}
}
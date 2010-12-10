package bgg

import scala.xml._ 


class Game(gameXML: Elem, item: Item) {
	
	val gameName = XMLParser.retrieveGameName(gameXML)
	
	val gameId: String = XMLParser.retrieveGameId(gameXML)
	
	val gameStats: GameStatistics = XMLParser.retrieveGameStatistics(gameXML)
	
	def printGameId(): Unit = {
		println(gameId)
	}
	
	def printGameStats(): Unit = {
		println(gameStats)
	}
	
}
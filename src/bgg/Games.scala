package bgg

import scala.xml._

class Games(gameXML: Elem) {

	private val gamesBaseUrl = "http://www.boardgamegeek.com/xmlapi/boardgame/"
	
	private val items = XMLParser.retrieveGameItems(gameXML)
	
	var games = List[Game]()
	
	var cnt = 1
	
	items foreach{(item) => 
		cnt += 1
		println(cnt)
		if (cnt < 4)
			games ::= new Game (BGGDataRetriever.retrieveXML(gamesBaseUrl + item.id), item)
	}
	
	val gameAnalysis = new GameAnalysis(games)
	
	gameAnalysis.printAnalysis(3,10)
}
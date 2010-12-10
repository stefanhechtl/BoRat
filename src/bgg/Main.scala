
package bgg
//import BGGDataRetriever.retrieveXML
object Main {
	def main(args: Array[String]) {

		val gamesBaseUrl = "http://www.boardgamegeek.com/xmlapi/boardgame/"
		val collectionBaseUrl = "http://www.boardgamegeek.com/xmlapi/collection/EinGlasWurstWasser?own=1"
		
		val xml = BGGDataRetriever.retrieveXML(collectionBaseUrl);

		var cnt = 1
		val games = new Games(xml)
	}
}
package bgg

import scala.xml._ 

object XMLParser {

	def retrieveGameId(xml: Elem): String = {
		(xml \\ "boardgame").last.attribute("objectid").get.toString
	}
	
	def retrieveGameName(xml: Elem): String = {
		(xml \\ "name").last.label
	}
	
	def retrieveGameItems(xml: Elem): List[Item] = {
		var retVal = List[Item]()
		xml \\ "item" foreach{(item) =>
			val gameId = item.attribute("objectid").get.toString
			var gameRank = 0
			var gameAvg = 0.0
			item \\ "stats" \\ "rating" \\ "ranks" \\ "rank" foreach{(rank) => 
				if (rank.attribute("type").get.toString.equals("subtype")){
					gameRank = rank.attribute("value").get.toString.toInt
					gameAvg = rank.attribute("bayesaverage").get.toString.toDouble
				}
			}
			retVal ::= new Item(gameId.toInt,1,gameRank,gameAvg)
		}
		retVal
	}
	
	def retrieveGameStatistics(xml: Elem): GameStatistics = {
		val stats = new GameStatistics()
		val polls = (xml \ "boardgame"\"poll") filter{(poll) => 
			poll.attribute("name").get.toString.equals("suggested_numplayers")
		}
		val suggestedNumPoll = polls.last
		suggestedNumPoll \ "results" foreach {(results) => 
			try{
			val numPlayers = results.attribute("numplayers").get.toString.toDouble
			results \ "result" foreach{(result) => 
				if (result.attribute("value").get.toString.equals("Not Recommended")){
					val numVotes = result.attribute("numvotes").get.toString
					stats.notRecommended(numPlayers.toInt, numVotes.toInt)
				}
				if (result.attribute("value").get.toString.equals("Recommended")){
					val numVotes = result.attribute("numvotes").get.toString
					stats.recommended(numPlayers.toInt, numVotes.toInt)
				}
				if (result.attribute("value").get.toString.equals("Best")){
					val numVotes = result.attribute("numvotes").get.toString
					stats.best(numPlayers.toInt, numVotes.toInt)
				}
			}
			}catch{
				case ex: NumberFormatException => 
			}
		}
		return stats
	}
}
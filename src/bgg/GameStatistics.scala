package bgg

import scala.collection.mutable._

class GameStatistics {

	private val stats = Map[Int, Map[String, Int]]()
	
	def notRecommended(numberOfPlayers: Int, numberOfVotes: Int): Unit = {
		if (stats.contains(numberOfPlayers)){
			var v = stats(numberOfPlayers)
			v.update("Not Recommended",numberOfVotes)
			stats += (numberOfPlayers -> v)
		}else{
			stats(numberOfPlayers) = Map("Not Recommended" -> numberOfVotes)
		}
	}
	
	def best(numberOfPlayers: Int, numberOfVotes: Int): Unit = {
		if (stats.contains(numberOfPlayers)){
			var v = stats(numberOfPlayers)
			v.update("Best",numberOfVotes)
			stats += (numberOfPlayers -> v)
		}else{
			stats(numberOfPlayers) = Map("Best" -> numberOfVotes)
		}
	}
	
	def recommended(numberOfPlayers: Int, numberOfVotes: Int): Unit = {
		if (stats.contains(numberOfPlayers)){
			var v = stats(numberOfPlayers)
			v.update("Recommended",numberOfVotes)
			stats += (numberOfPlayers -> v)
		}else{
			stats(numberOfPlayers) = Map("Recommended" -> numberOfVotes)
		}
	}
	
	def getStats(numberOfPlayers: Int): Map[String, Int] = {
		stats(numberOfPlayers)
	}
	
	def getBestStats(numberOfPlayers: Int): Double = {
 		getStats(numberOfPlayers)("Best") / (getStats(numberOfPlayers)("Best") + getStats(numberOfPlayers)("Recommended") + getStats(numberOfPlayers)("Not Recommended")) 
	}
	
	override def toString(): String = {
		var retVal = ""
		stats.toString
	}
	
}
package bgg

import scala.collection.mutable._

class BenchmarkImpl {

	def applyBenchmark(games: List[Game]): List[Game] = {
		val benchmark = new HashMap[Game, Double]()
		games foreach{(game) =>
			benchmark += game -> gameBenchmark(game)
		}
		returnTopNGames(benchmark, n)

	}	
	
	def gameBenchmark(game: Game): Double = {
		val recommendationRate = game.gameStats
		return 0.0
	}
	
	def returnTopNGames(benchmark: Map[Game, Double], n: Int): List[Game] = {
		return List()
	}
	
}
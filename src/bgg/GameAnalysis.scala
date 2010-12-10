package bgg

class GameAnalysis(games: List[Game]) {

	val benchmark = new BenchmarkImpl()
	
	def printAnalysis(numberOfPlayers: Int, topN: Int): Unit = {
		val benchmarkedGames = benchmark.applyBenchmark(games)
	}
	
}
package day11

import kotlin.math.pow
import utils.ParseFile

class Day11(private val input: List<Long>) {

  private var visited = HashMap<Pair<Long, Int>, Long>()

  fun solve(blinks: Int): Long {
    var result = 0L

    for (stone in input) {
      result += solve(stone, blinks)
    }

    return result
  }

  private fun solve(stone: Long, remainingBlinks: Int): Long {
    val knownOutcome = visited[Pair(stone, remainingBlinks)]
    if (knownOutcome != null) {
      return knownOutcome
    }

    if (remainingBlinks == 0) {
      return 1
    }

    if (stone == 0L) {
      val result = solve(1L, remainingBlinks - 1)
      visited[Pair(stone, remainingBlinks)] = result
      return result
    }

    val stoneSize = stone.toString().length
    if (stoneSize % 2 == 0) {
      val result =
          solve((stone / 10.0.pow(stoneSize / 2)).toLong(), remainingBlinks - 1) +
              solve((stone % 10.0.pow(stoneSize / 2)).toLong(), remainingBlinks - 1)
      visited[Pair(stone, remainingBlinks)] = result
      return result
    }

    val result = solve(stone * 2024, remainingBlinks - 1)
    visited[Pair(stone, remainingBlinks)] = result
    return result
  }
}

fun main() {
  println(Day11(ParseFile.parseFileToListOfLong("day11/input.txt", " ")).solve(25))
  println(Day11(ParseFile.parseFileToListOfLong("day11/input.txt", " ")).solve(75))
}

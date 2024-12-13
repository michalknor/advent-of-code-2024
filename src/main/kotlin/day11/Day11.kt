package day11

import kotlin.math.pow
import utils.ParseFile

// If the stone is engraved with the number 0, it is replaced by a stone engraved with the number 1.

// If the stone is engraved with a number that has an even number of digits, it is replaced by two
// stones. The left half of the digits are engraved on the new left stone, and the right half of the
// digits are engraved on the new right stone. (The new numbers don't keep extra leading zeroes:
// 1000 would become stones 10 and 0.)

// If none of the other rules apply, the stone is replaced by a new stone; the old stone's number
// multiplied by 2024 is engraved on the new stone.

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
      val result = solve((stone / 10.0.pow(stoneSize / 2)).toLong(), remainingBlinks - 1) +
          solve((stone % 10.0.pow(stoneSize / 2)).toLong(), remainingBlinks - 1)
      visited[Pair(stone, remainingBlinks)] = result
      return result
    }

    val result = solve(stone * 2024, remainingBlinks - 1)
    visited[Pair(stone, remainingBlinks)] = result
    return result
  }

  //
  //    var stones = input
  //
  //    for (i in 0 until blinks) {
  //      val newStones = emptyList<Long>().toMutableList()
  //      for (stone in stones) {
  //        if (stone == 0L) {
  //          newStones.add(1)
  //          continue
  //        }
  //        val stoneSize = stone.toString().length
  //        if (stoneSize % 2 == 0) {
  //          newStones.add((stone / 10.0.pow(stoneSize / 2)).toLong())
  //          newStones.add((stone % 10.0.pow(stoneSize / 2)).toLong())
  //          continue
  //        }
  //        newStones.add(stone * 2024)
  //      }
  //      stones = newStones
  //      println(stones)
  //    }
  //    return stones.size
}

fun main() {
  println(Day11(ParseFile.parseFileToListOfLong("day11/input.txt", " ")).solve(25))
    println(Day11(ParseFile.parseFileToListOfLong("day11/input.txt", " ")).solve(75))
}

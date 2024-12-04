package day02

import utils.ParseFile

class Day02(private val input: List<List<Int>>) {
  fun solvePart1(): Int = input.map { level -> if (isSafe(level) == 0) 1 else 0 }.sum()

  fun solvePart2(): Int = input.map { level -> if (isSafeWithRemoval(level)) 1 else 0 }.sum()

  private fun isSafe(levels: List<Int>): Int {
    val increasing = if (levels[0] < levels[1]) 1 else -1
    var previous = levels[0]

    levels.forEachIndexed { index, current ->
      if (index == 0) {
        return@forEachIndexed
      }
      if (current != previous + increasing * 1 &&
          current != previous + increasing * 2 &&
          current != previous + increasing * 3) {
        return index
      }
      previous = current
    }

    return 0
  }

  private fun isSafeWithRemoval(levels: List<Int>): Boolean {
    return when (val isSafe = isSafe(levels)) {
      0 -> true
      else ->
          isSafe(levels.filterIndexed { index, _ -> index != isSafe - 1 }) == 0 ||
              isSafe(levels.filterIndexed { index, _ -> index != isSafe }) == 0
    }
  }
}

fun main() {
  println(Day02(ParseFile.parseFileToListOfListOfInt("day02/input.txt")).solvePart1())
  println(Day02(ParseFile.parseFileToListOfListOfInt("day02/input.txt")).solvePart2())
}

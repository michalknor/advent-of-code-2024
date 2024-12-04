package day04

import utils.Direction
import utils.ParseFile

class Day04(private val input: List<List<Char>>) {
  companion object {
    private const val wordToFind: String = "XMAS"
  }

  fun solvePart1(): Int {
    var result = 0

    getStartingPositions('X').forEach { (x, y) -> result += xmasSearchCount(x, y) }
    return result
  }

  private fun xmasSearchCount(x: Int, y: Int): Int =
      Direction.getAllDirections().map { direction -> xmasSearchCount(x, y, 1, direction) }.sum()

  private fun xmasSearchCount(
      x: Int,
      y: Int,
      position: Int,
      direction: Direction.DirectionType
  ): Int {
    val (newX, newY) = Pair(x + direction.dx, y + direction.dy)

    if (newX !in input[0].indices || newY !in input.indices) {
      return 0
    }
    if (wordToFind[position] != input[newY][newX]) {
      return 0
    }
    if (position + 1 != wordToFind.length) {
      return xmasSearchCount(newX, newY, position + 1, direction)
    }
    return 1
  }

  fun solvePart2(): Int {
    var result = 0

    getStartingPositions('A').forEach { (x, y) -> result += masSearchCount(x, y) }

    return result
  }

  private fun masSearchCount(x: Int, y: Int): Int {
    if (x - 1 !in input[0].indices ||
        y - 1 !in input.indices ||
        x + 1 !in input[0].indices ||
        y + 1 !in input.indices) {
      return 0
    }
    if (input[y - 1][x - 1] in listOf('M', 'S') &&
        input[y + 1][x + 1] in listOf('M', 'S') &&
        input[y - 1][x + 1] in listOf('M', 'S') &&
        input[y + 1][x - 1] in listOf('M', 'S') &&
        input[y - 1][x - 1] != input[y + 1][x + 1] &&
        input[y - 1][x + 1] != input[y + 1][x - 1]) {
      return 1
    }
    return 0
  }

  private fun getStartingPositions(character: Char): List<Pair<Int, Int>> =
      input.flatMapIndexed { yIndex, row ->
        row.mapIndexedNotNull { xIndex, char ->
          if (char == character) Pair(xIndex, yIndex) else null
        }
      }
}

fun main() {
  println(Day04(ParseFile.parseFileToListOfListOfChars("day04/input.txt")).solvePart1())
  println(Day04(ParseFile.parseFileToListOfListOfChars("day04/input.txt")).solvePart2())
}

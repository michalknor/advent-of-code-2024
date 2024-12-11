package day10

import utils.Direction
import utils.ParseFile

class Day10(private val input: List<List<Int>>) {

  fun solvePart1(): Int = solve(true)

  fun solvePart2(): Int = solve(false)

  private fun solve(simple: Boolean): Int {
    val visited = HashSet<List<Pair<Int, Int>>>()
    val positions =
        input.flatMapIndexed { y, row ->
          row.mapIndexedNotNull { x, value -> if (value == 9) x to y else null }
        }

    val queue = mutableListOf<List<Pair<Int, Int>>>()
    for (position in positions) {
      queue.add(listOf(position))
    }

    while (queue.isNotEmpty()) {
      val currentItem = queue.removeAt(queue.size - 1)
      val currentPosition = currentItem[currentItem.size - 1]
      val currentHeight = input[currentPosition.second][currentPosition.first]

      for (direction in Direction.getAllCardinalDirections()) {
        val nextPosition =
            Pair(currentPosition.first + direction.dx, currentPosition.second + direction.dy)
        if (nextPosition.first !in input[0].indices || nextPosition.second !in input.indices) {
          continue
        }
        val nextHeight = input[nextPosition.second][nextPosition.first]
        if (nextHeight + 1 != currentHeight) {
          continue
        }
        if (nextHeight == 0) {
          if (simple) {
            visited.add(listOf(currentItem[0], nextPosition))
            continue
          }
          visited.add(currentItem + nextPosition)
        }
        if (simple) {
          queue.add(listOf(currentItem[0], nextPosition))
          continue
        }
        queue.add(currentItem + nextPosition)
      }
    }

    return visited.size
  }
}

fun main() {
  println(Day10(ParseFile.parseFileToListOfListOfInt("day10/input.txt", "")).solvePart1())
  println(Day10(ParseFile.parseFileToListOfListOfInt("day10/input.txt", "")).solvePart2())
}

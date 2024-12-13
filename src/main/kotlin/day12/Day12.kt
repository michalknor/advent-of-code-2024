package day12

import utils.Direction
import utils.ParseFile

class Day12(private val input: List<List<Char>>) {

  fun solvePart1(): Int {
    val queue =
        input
            .flatMapIndexed { row, list -> List(list.size) { col -> Pair(row, col) } }
            .toMutableList()

    var result = 0

    while (queue.isNotEmpty()) {
      val plantLocation = queue.removeAt(queue.size - 1)
      val plantQueue = mutableListOf(Pair(plantLocation.first, plantLocation.second))
      val plantSymbol = input[plantLocation.second][plantLocation.first]
      var perimeter = 0
      var area = 0

      while (plantQueue.isNotEmpty()) {
        val newPlantLocation = plantQueue.removeAt(plantQueue.size - 1)
        println(newPlantLocation)
        if (newPlantLocation.first !in input[0].indices || newPlantLocation.second !in input.indices) {
          continue
        }
        if (input[newPlantLocation.second][newPlantLocation.first] != plantSymbol) {
          perimeter += 1
          continue
        }
        if (queue.indexOf(newPlantLocation) == -1) {
          continue
        }
        queue.remove(newPlantLocation)
        area += 1
        for (direction in Direction.getAllCardinalDirections()) {
          plantQueue.add(
              Pair(plantLocation.first + direction.dx, plantLocation.second + direction.dy))
        }
      }
      result += area * perimeter
    }

    return result
  }

  fun solvePart2(): Int {
    return 1
  }
}

fun main() {
  println(Day12(ParseFile.parseFileToListOfListOfChars("day12/input.txt")).solvePart1())
  println(Day12(ParseFile.parseFileToListOfListOfChars("day12/input.txt")).solvePart2())
}

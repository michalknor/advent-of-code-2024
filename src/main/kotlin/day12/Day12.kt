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
      val plantLocation = queue[queue.size - 1]
      val plantQueue = mutableListOf(Pair(plantLocation.first, plantLocation.second))
      val plantSymbol = input[plantLocation.second][plantLocation.first]
      var perimeter = 0
      var area = 0

      while (plantQueue.isNotEmpty()) {
        val newPlantLocation = plantQueue.removeAt(plantQueue.size - 1)
        if (newPlantLocation.first !in input[0].indices ||
            newPlantLocation.second !in input.indices ||
            input[newPlantLocation.second][newPlantLocation.first] != plantSymbol) {
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
              Pair(newPlantLocation.first + direction.dx, newPlantLocation.second + direction.dy))
        }
      }
      result += area * perimeter
    }

    return result
  }

  fun solvePart2(): Int {
    val queue =
        input
            .flatMapIndexed { row, list -> List(list.size) { col -> Pair(row, col) } }
            .toMutableList()

    var result = 0

    while (queue.isNotEmpty()) {
      val plantLocation = queue[queue.size - 1]
      val plantQueue =
          mutableListOf(
              Triple(
                  Pair(plantLocation.first, plantLocation.second),
                  Pair(plantLocation.first, plantLocation.second),
                  Direction.DirectionType.N))
      val plantSymbol = input[plantLocation.second][plantLocation.first]
      var area = 0
      val sides = HashMap<Direction.DirectionType, MutableSet<Pair<Int, Int>>>()

      while (plantQueue.isNotEmpty()) {
        val (oldPlantLocation, newPlantLocation, oldDirection) =
            plantQueue.removeAt(plantQueue.size - 1)
        if (newPlantLocation.first !in input[0].indices ||
            newPlantLocation.second !in input.indices ||
            input[newPlantLocation.second][newPlantLocation.first] != plantSymbol) {
          sides.getOrPut(oldDirection) { mutableSetOf() }.add(oldPlantLocation)
          continue
        }
        if (queue.indexOf(newPlantLocation) == -1) {
          continue
        }
        queue.remove(newPlantLocation)
        area += 1
        for (direction in Direction.getAllCardinalDirections()) {
          plantQueue.add(
              Triple(
                  newPlantLocation,
                  Pair(
                      newPlantLocation.first + direction.dx,
                      newPlantLocation.second + direction.dy),
                  direction))
        }
      }

      var numberOfSides = 0
      for (sideType in sides) {
        val directionType = sideType.key
        val sideParts = sideType.value
        while (sideParts.isNotEmpty()) {
          val pivotSide = sideParts.first().also { sideParts.remove(it) }
          var sideToFind =
              Pair(pivotSide.first + directionType.dy, pivotSide.second + directionType.dx)
          numberOfSides++
          while (sideParts.contains(sideToFind)) {
            sideParts.remove(sideToFind)
            sideToFind =
                Pair(sideToFind.first + directionType.dy, sideToFind.second + directionType.dx)
          }
          sideToFind = Pair(pivotSide.first - directionType.dy, pivotSide.second - directionType.dx)
          while (sideParts.contains(sideToFind)) {
            sideParts.remove(sideToFind)
            sideToFind =
                Pair(sideToFind.first - directionType.dy, sideToFind.second - directionType.dx)
          }
        }
      }

      result += area * numberOfSides
    }

    return result
  }
}

fun main() {
  println(Day12(ParseFile.parseFileToListOfListOfChars("day12/input.txt")).solvePart1())
  println(Day12(ParseFile.parseFileToListOfListOfChars("day12/input.txt")).solvePart2())
}

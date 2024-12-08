package day06

import utils.Direction
import utils.ParseFile

class Day06(private val input: List<List<Char>>) {

  private val startingPosition =
      input
          .flatMapIndexed { row, list ->
            list.mapIndexedNotNull { col, c -> if (c == '^') Pair(col, row) else null }
          }
          .first()

  fun solvePart1(): Int = getVisitedPositions().size

  fun solvePart2(): Int {
    val visitedPositions = getVisitedPositions()
    var result = 0

    for (positions in visitedPositions) {
      val grid = input.toMutableList()
      val rowIndex = positions.second
      val colIndex = positions.first

      val row = grid[rowIndex].toMutableList()
      row[colIndex] = '#'

      grid[rowIndex] = row
      val newGrid = grid.toList()
      if (isLooping(newGrid)) {
        result++
      }
    }

    return result
  }

  private fun getVisitedPositions(): MutableSet<Pair<Int, Int>> {
    val visitedPositions = mutableSetOf(startingPosition)
    var currentDirectionIndex = 0
    var currentDirection = Direction.getAllCardinalDirections()[currentDirectionIndex]
    var currentPosition = startingPosition

    while (true) {
      while (nextPositionIsClear(currentPosition, currentDirection)) {
        currentPosition =
            Pair(
                currentPosition.first + currentDirection.dx,
                currentPosition.second + currentDirection.dy)
        visitedPositions.add(currentPosition)
      }
      if (isEscaping(currentPosition, currentDirection)) {
        break
      }
      currentDirectionIndex = (currentDirectionIndex + 1) % 4
      currentDirection = Direction.getAllCardinalDirections()[currentDirectionIndex]
    }

    return visitedPositions
  }

  private fun isLooping(grid: List<List<Char>>): Boolean {
    var currentDirectionIndex = 0
    var currentDirection = Direction.getAllCardinalDirections()[currentDirectionIndex]
    var currentPosition = startingPosition
    val visitedPositions = mutableSetOf(Pair(startingPosition, currentDirection))

    while (true) {
      while (nextPositionIsClear(currentPosition, currentDirection, grid)) {
        currentPosition =
            Pair(
                currentPosition.first + currentDirection.dx,
                currentPosition.second + currentDirection.dy)

        if (visitedPositions.contains(Pair(currentPosition, currentDirection))) {
          return true
        }

        visitedPositions.add(Pair(currentPosition, currentDirection))
      }
      if (isEscaping(currentPosition, currentDirection, grid)) {
        break
      }
      currentDirectionIndex = (currentDirectionIndex + 1) % 4
      currentDirection = Direction.getAllCardinalDirections()[currentDirectionIndex]
    }

    return false
  }

  private fun nextPositionIsClear(
      currentPosition: Pair<Int, Int>,
      currentDirection: Direction.DirectionType,
      grid: List<List<Char>> = input
  ): Boolean {
    val nextPosition =
        Pair(
            currentPosition.first + currentDirection.dx,
            currentPosition.second + currentDirection.dy)

    return (nextPosition.first in grid[0].indices &&
        nextPosition.second in grid.indices &&
        grid[nextPosition.second][nextPosition.first] != '#')
  }

  private fun isEscaping(
      currentPosition: Pair<Int, Int>,
      currentDirection: Direction.DirectionType,
      grid: List<List<Char>> = input
  ): Boolean {
    val nextPosition =
        Pair(
            currentPosition.first + currentDirection.dx,
            currentPosition.second + currentDirection.dy)

    return (nextPosition.first !in grid[0].indices || nextPosition.second !in grid.indices)
  }
}

fun main() {
  println(Day06(ParseFile.parseFileToListOfListOfChars("day06/input.txt")).solvePart1())
  println(Day06(ParseFile.parseFileToListOfListOfChars("day06/input.txt")).solvePart2())
}

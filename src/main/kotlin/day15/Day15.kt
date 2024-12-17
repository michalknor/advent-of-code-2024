package day15

import utils.Direction
import utils.ParseFile

class Day15(input: String) {

  private val grid = input.split(Regex("""(\r\n){2}"""))[0].lines().map { it.toList() }

  private val instructions =
      input.split(Regex("""(\r\n){2}"""))[1].filter { it != '\n' && it != '\r' }.toCharArray()

  fun solvePart1(): Int {
    var position =
        grid
            .mapIndexedNotNull { row, line ->
              line.indexOf('@').takeIf { it >= 0 }?.let { col -> col to row }
            }
            .first()

    val newGrid = grid.map { it.toMutableList() }.toMutableList()

    newGrid[position.second][position.first] = '.'

    for (instruction in instructions) {

      val direction =
          when (instruction) {
            '>' -> Direction.DirectionType.E
            'v' -> Direction.DirectionType.S
            '<' -> Direction.DirectionType.W
            else -> Direction.DirectionType.N
          }

      val nextPosition = Pair(position.first + direction.dx, position.second + direction.dy)

      when (newGrid[nextPosition.second][nextPosition.first]) {
        '.' -> {
          position = nextPosition
          continue
        }
        '#' -> continue
      }

      var nextPositionO =
          Pair(nextPosition.first + direction.dx, nextPosition.second + direction.dy)

      while (true) {
        when (newGrid[nextPositionO.second][nextPositionO.first]) {
          '.' -> {
            newGrid[nextPositionO.second][nextPositionO.first] = 'O'
            newGrid[nextPosition.second][nextPosition.first] = '.'
            position = nextPosition
            break
          }
          '#' -> break
        }
        nextPositionO =
            Pair(nextPositionO.first + direction.dx, nextPositionO.second + direction.dy)
      }
    }

    return newGrid
        .flatMapIndexed { row, line ->
          line.mapIndexed { col, char -> if (char == 'O') row * 100 + col else 0 }
        }
        .sum()
  }

  fun solvePart2(): Int {
    return 1
  }
}

fun main() {
  println(Day15(ParseFile.parseFileToString("day15/input.txt")).solvePart1())
  println(Day15(ParseFile.parseFileToString("day15/input.txt")).solvePart2())
}

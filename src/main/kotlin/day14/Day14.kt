package day14

import utils.ParseFile

class Day14(input: List<String>) {

  private val robots =
      input.mapNotNull { line ->
        val matchResult = Regex("""p=(-?\d+),(-?\d+)\s+v=(-?\d+),(-?\d+)""").find(line)
        matchResult?.let {
          val (px, py, vx, vy) = it.destructured
          Pair(Pair(px.toInt(), py.toInt()), Pair(vx.toInt(), vy.toInt()))
        }
      }

  fun solvePart1(width: Int, height: Int): Int {
    val quadrants = mutableListOf(0, 0, 0, 0)
    for (robot in robots) {
      var (x, y) =
          Pair(
              (robot.first.first + robot.second.first * 100) % width,
              (robot.first.second + robot.second.second * 100) % height)

      if (x < 0) {
        x += width
      }
      if (y < 0) {
        y += height
      }

      if (x < width / 2 && y < height / 2) {
        quadrants[0]++
      } else if (x > width / 2 && y < height / 2) {
        quadrants[1]++
      } else if (x < width / 2 && y > height / 2) {
        quadrants[2]++
      } else if (x > width / 2 && y > height / 2) {
        quadrants[3]++
      }
    }

    return quadrants[0] * quadrants[1] * quadrants[2] * quadrants[3]
  }

  fun solvePart2(width: Int, height: Int): Int {
    var iteration = 0
    while (true) {
      iteration++
      val positions = mutableSetOf<Pair<Int, Int>>()
      for (robot in robots) {
        var (x, y) =
            Pair(
                (robot.first.first + robot.second.first * iteration) % width,
                (robot.first.second + robot.second.second * iteration) % height)

        if (x < 0) {
          x += width
        }
        if (y < 0) {
          y += height
        }

        positions.add(Pair(x, y))
      }

      for (position in positions) {
        if (positions.contains(Pair(position.first - 1, position.second - 1)) &&
            positions.contains(Pair(position.first - 1, position.second)) &&
            positions.contains(Pair(position.first - 1, position.second + 1)) &&
            positions.contains(Pair(position.first, position.second - 1)) &&
            positions.contains(Pair(position.first, position.second + 1)) &&
            positions.contains(Pair(position.first + 1, position.second - 1)) &&
            positions.contains(Pair(position.first + 1, position.second)) &&
            positions.contains(Pair(position.first + 1, position.second + 1))) {
          for (j in 0..103) {
            for (i in 0..101) {
              if (positions.contains(Pair(i, j))) {
                print("#")
              } else {
                print(" ")
              }
            }
            println()
          }
          return iteration
        }
      }
    }
  }
}

fun main() {
  println(Day14(ParseFile.parseFileToList("day14/input.txt")).solvePart1(101, 103))
  println(Day14(ParseFile.parseFileToList("day14/input.txt")).solvePart2(101, 103))
}

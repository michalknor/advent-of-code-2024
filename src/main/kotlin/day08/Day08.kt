package day08

import utils.ParseFile

class Day08(private val input: List<List<Char>>) {

  private val charsPositions =
      input
          .flatMapIndexed { y, list ->
            list.mapIndexedNotNull { x, char -> if (char != '.') char to Pair(x, y) else null }
          }
          .groupBy({ it.first }, { it.second })

  fun solvePart1(): Int {
    val antinodes = HashSet<Pair<Int, Int>>()

    for (charPositions in charsPositions) {
      for (i in 0 until charPositions.value.size) {
        val first = charPositions.value[i]
        for (j in i + 1 until charPositions.value.size) {
          val second = charPositions.value[j]
          val vector = Pair(second.first - first.first, second.second - first.second)
          val antinode1 = Pair(second.first + vector.first, second.second + vector.second)
          val antinode2 = Pair(first.first - vector.first, first.second - vector.second)

          if (antinode1.first in input[0].indices && antinode1.second in input.indices) {
            antinodes.add(antinode1)
          }
          if (antinode2.first in input[0].indices && antinode2.second in input.indices) {
            antinodes.add(antinode2)
          }
        }
      }
    }

    return antinodes.size
  }

  fun solvePart2(): Int {
    val antinodes = HashSet<Pair<Int, Int>>()

    for (charPositions in charsPositions) {
      for (i in 0 until charPositions.value.size) {
        val first = charPositions.value[i]
        for (j in i + 1 until charPositions.value.size) {
          val second = charPositions.value[j]
          val vector = Pair(second.first - first.first, second.second - first.second)
          antinodes.add(second)
          antinodes.add(first)

          var k = 1
          while (true) {
            val antinode1 = Pair(second.first + vector.first * k, second.second + vector.second * k)
            if (antinode1.first !in input[0].indices || antinode1.second !in input.indices) {
              break
            }
            antinodes.add(antinode1)
            k++
          }
          k = 1
          while (true) {
            val antinode2 = Pair(first.first - vector.first * k, first.second - vector.second * k)
            if (antinode2.first !in input[0].indices || antinode2.second !in input.indices) {
              break
            }
            antinodes.add(antinode2)
            k++
          }
        }
      }
    }

    return antinodes.size
  }
}

fun main() {
  println(Day08(ParseFile.parseFileToListOfListOfChars("day08/input.txt")).solvePart1())
  println(Day08(ParseFile.parseFileToListOfListOfChars("day08/input.txt")).solvePart2())
}

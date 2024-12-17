package day13

import utils.ParseFile

class Day13(input: String) {

  private val machines =
      input.split(Regex("""(\r\n){2}""")).map { group ->
        val coords =
            group.lines().map { "\\d+".toRegex().findAll(it).map { it.value.toLong() }.toList() }
        Triple(
            Pair(coords[0][0], coords[0][1]),
            Pair(coords[1][0], coords[1][1]),
            Pair(coords[2][0], coords[2][1]))
      }

  fun solvePart1(): Long {
    var result = 0L

    for (machine in machines) {
      val (a, b) = solve(machine, 0)
      if (a in 0..100 && b in 0..100) {
        result += a * 3 + b
      }
    }

    return result
  }

  fun solvePart2(): Long {
    var result = 0L

    for (machine in machines) {
      val (a, b) = solve(machine, 10000000000000)

      if (a >= 0 && b >= 0) {
        result += a * 3 + b
      }
    }

    return result
  }

  private fun solve(
      machine: Triple<Pair<Long, Long>, Pair<Long, Long>, Pair<Long, Long>>,
      higher: Long
  ): Pair<Long, Long> {
    val buttonA = machine.first
    val buttonB = machine.second
    val prize = Pair(machine.third.first + higher, machine.third.second + higher)

    val leftSide = buttonA.first * (-buttonB.second) + buttonA.second * (buttonB.first)
    val rightSide = prize.first * (-buttonB.second) + prize.second * (buttonB.first)

    if (rightSide % leftSide != 0L) {
      return Pair(-1, -1)
    }

    val buttonACount = rightSide / leftSide
    val buttonBCount = (prize.first - buttonACount * buttonA.first) / buttonB.first

    if ((prize.first - buttonACount * buttonA.first) % buttonB.first != 0L) {
      return Pair(-1, -1)
    }

    return Pair(buttonACount, buttonBCount)
  }
}

fun main() {
  println(Day13(ParseFile.parseFileToString("day13/input.txt")).solvePart1())
  println(Day13(ParseFile.parseFileToString("day13/input.txt")).solvePart2())
}

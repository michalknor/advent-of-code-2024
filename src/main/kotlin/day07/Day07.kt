package day07

import utils.ParseFile

class Day07(input: List<String>) {
  private val lines =
      input.map {
        it.split(":").let { (key, value) ->
          key.trim().toLong() to value.trim().split(" ").map(String::toLong)
        }
      }

  fun solvePart1(): Long {
    var result = 0L

    for (line in lines) {
      if (getNumberOfPossibleEquations(line.first, 0, line.second)) {
        result += line.first
      }
    }

    return result
  }

  fun solvePart2(): Long {
    var result = 0L

    for (line in lines) {
      if (getNumberOfPossibleEquations2(line.first, 0, line.second)) {
        result += line.first
      }
    }

    return result
  }

  private fun getNumberOfPossibleEquations(
      result: Long,
      current: Long,
      numbers: List<Long>
  ): Boolean {
    if (numbers.isEmpty()) {
      return result == current
    }
    if (current > result) {
      return false
    }
    if (numbers.size == 1) {
      return getNumberOfPossibleEquations(result, current + numbers[0], emptyList()) ||
          getNumberOfPossibleEquations(result, current * numbers[0], emptyList())
    }
    return getNumberOfPossibleEquations(
        result, current * numbers[0], numbers.subList(1, numbers.size)) ||
        getNumberOfPossibleEquations(result, current + numbers[0], numbers.subList(1, numbers.size))
  }

  private fun getNumberOfPossibleEquations2(
      result: Long,
      current: Long,
      numbers: List<Long>
  ): Boolean {
    if (numbers.isEmpty()) {
      return result == current
    }
    if (current > result) {
      return false
    }
    if (numbers.size == 1) {
      return getNumberOfPossibleEquations2(
          result,
          (current.toString() + numbers[0].toString()).toLong(),
          numbers.subList(1, numbers.size)) ||
          getNumberOfPossibleEquations2(result, current + numbers[0], emptyList()) ||
          getNumberOfPossibleEquations2(result, current * numbers[0], emptyList())
    }
    return getNumberOfPossibleEquations2(
        result,
        (current.toString() + numbers[0].toString()).toLong(),
        numbers.subList(1, numbers.size)) ||
        getNumberOfPossibleEquations2(
            result, current * numbers[0], numbers.subList(1, numbers.size)) ||
        getNumberOfPossibleEquations2(
            result, current + numbers[0], numbers.subList(1, numbers.size))
  }
}

fun main() {
  println(Day07(ParseFile.parseFileToList("day07/input.txt")).solvePart1())
  println(Day07(ParseFile.parseFileToList("day07/input.txt")).solvePart2())
}

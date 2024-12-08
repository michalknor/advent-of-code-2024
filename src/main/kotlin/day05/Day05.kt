package day05

import utils.ParseFile

class Day05(private val input: String) {
  private val rulesList =
      input.split(Regex("""(\r\n){2}"""))[0].split(Regex("""\r\n""")).map { line ->
        line.split("|").map { it.toInt() }
      }

  private val updates =
      input.split(Regex("""(\r\n){2}"""))[1].split(Regex("""\r\n""")).map { line ->
        line.split(",").map { it.toInt() }
      }

  private val rulesMap = rulesList.groupBy({ it[0] }, { it[1] }).mapValues { HashSet(it.value) }

  fun solvePart1(): Int {
    var result = 0

    for (update in updates) {
      if (isValid(update) == Pair(0, 0)) {
        result += update[update.size / 2]
      }
    }

    return result
  }

  private fun isValid(update: List<Int>): Pair<Int, Int> {
    for (i in 1 until update.size) {
      val previousPages = update.subList(0, i)
      val current = update[i]
      if (rulesMap[current] == null) {
        continue
      }
      for (previousPage in previousPages) {
        if (rulesMap[current]?.contains(previousPage) == true) {
          return Pair(current, previousPage)
        }
      }
    }

    return Pair(0, 0)
  }

  fun solvePart2(): Int {
    var result = 0

    for (update in updates) {
      var update = update
      var isIncorrect = false
      while (true) {
        val status = isValid(update)
        if (status == Pair(0, 0)) {
          if (isIncorrect) {
            result += update[update.size / 2]
          }
          break
        }
        update = update.filter { it != status.first }
        val index = update.indexOf(status.second)
        update = update.subList(0, index) + status.first + update.subList(index, update.size)

        isIncorrect = true
      }
    }

    return result
  }
}

fun main() {
  println(Day05(ParseFile.parseFileToString("day05/input.txt")).solvePart1())
  println(Day05(ParseFile.parseFileToString("day05/input.txt")).solvePart2())
}

package day09

import utils.ParseFile

class Day09(private val input: List<Int>) {

  fun solvePart1(): Long {
    val disk = mutableListOf<Long>()

    var finalSize = 0

    for ((id, i) in (input.indices step 2).withIndex()) {
      val filled = input[i]
      for (j in 1..filled) {
        disk.add(id.toLong())
      }
      finalSize += filled
      if (i + 1 == input.size) {
        break
      }
      val empty = input[i + 1]
      for (j in 1..empty) {
        disk.add(-1)
      }
    }

    while (disk.size != finalSize) {
      disk[disk.indexOf(-1)] = disk.removeAt(disk.size - 1)
    }

    var result = 0L
    for ((i, it) in disk.withIndex()) {
      if (it != -1L) {
        result += i.toLong() * it
      }
    }
    return result
  }

  fun solvePart2(): Long {
    val emptySpaces = mutableListOf<Pair<Int, Int>>()
    val filledSpaces = mutableListOf<Triple<Int, Int, Long>>()
    var discLocation = 0

    var finalSize = 0

    for ((id, i) in (input.indices step 2).withIndex()) {
      val filled = input[i]
      discLocation += filled
      filledSpaces.add(Triple(discLocation - filled, filled, id.toLong()))
      finalSize += filled
      if (i + 1 == input.size) {
        break
      }
      val empty = input[i + 1]
      if (empty == 0) {
        continue
      }
      discLocation += empty
      emptySpaces.add(Pair(discLocation - empty, empty))
    }

    for (i in filledSpaces.indices.reversed()) {
      val filledSpace = filledSpaces[i]
      for ((j, emptySpace) in emptySpaces.withIndex()) {
        if (emptySpace.first > filledSpaces[i].first) {
          break
        }
        if (emptySpace.second >= filledSpace.second) {
          emptySpaces[j] =
              Pair(emptySpace.first + filledSpace.second, emptySpace.second - filledSpace.second)
          filledSpaces[i] = Triple(emptySpace.first, filledSpace.second, filledSpace.third)
          if (emptySpaces[j].second == 0) {
            emptySpaces.removeAt(j)
          }
          break
        }
      }
    }

    var result = 0L
    for (it in filledSpaces) {
      for (i in it.first until it.first + it.second) {
        result += it.third * i
      }
    }

    return result
  }
}

fun main() {
  println(Day09(ParseFile.parseFileToListOfInt("day09/input.txt")).solvePart1())
  println(Day09(ParseFile.parseFileToListOfInt("day09/input.txt")).solvePart2())
}

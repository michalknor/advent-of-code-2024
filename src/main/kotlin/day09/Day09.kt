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

    return calculateCheckSum(disk)
  }

  fun solvePart2(): Long {
    val emptySpaces = mutableListOf<Triple<Int, Int, Long>>()
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
      discLocation += empty
      emptySpaces.add(Triple(discLocation - empty, empty, id.toLong()))
    }

    println(filledSpaces)
    println(emptySpaces)

    for (filledSpace in filledSpaces.reversed()) {
      for ((i, it) in emptySpaces.withIndex()) {
        if (it.second >= filledSpace.second) {
          break;
        }
      }
    }

    return 1
  }

  private fun calculateCheckSum(disk: MutableList<Long>): Long {
    var result = 0L
    for ((i, it) in disk.withIndex()) {
      if (it != -1L) {
        result += i.toLong() * it
      }
    }
    return result
  }
}

fun main() {
  println(Day09(ParseFile.parseFileToListOfInt("day09/input.txt")).solvePart1())
  println(Day09(ParseFile.parseFileToListOfInt("day09/input.txt")).solvePart2())
}

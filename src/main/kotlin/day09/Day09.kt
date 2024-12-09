package day09

import utils.ParseFile

class Day09(private val input: List<Int>) {

  fun solvePart1(): Long {
    println(input)
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
      println(i * it)
      result += i.toLong() * it
    }

    println(disk)

    return result
  }

  fun solvePart2(): Int {
    return 1
  }
}

fun main() {
  println(Day09(ParseFile.parseFileToListOfInt("day09/input.txt")).solvePart1())
  println(Day09(ParseFile.parseFileToListOfInt("day09/input.txt")).solvePart2())
}

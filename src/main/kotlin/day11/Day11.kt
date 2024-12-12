package day11

import utils.ParseFile
import kotlin.math.pow

// If the stone is engraved with the number 0, it is replaced by a stone engraved with the number 1.

// If the stone is engraved with a number that has an even number of digits, it is replaced by two
// stones. The left half of the digits are engraved on the new left stone, and the right half of the
// digits are engraved on the new right stone. (The new numbers don't keep extra leading zeroes:
// 1000 would become stones 10 and 0.)

// If none of the other rules apply, the stone is replaced by a new stone; the old stone's number
// multiplied by 2024 is engraved on the new stone.

class Day11(private val input: List<Int>) {

  fun solvePart1(blinks: Int): Int {
    var stones = input

    for (i in 1 until blinks) {
      val newStones = emptyList<Int>().toMutableList()
      for (stone in stones) {
        if (stone == 0) {
          newStones.add(1)
          continue
        }
        val stoneSize = stone.toString().length
        if (stoneSize % 2 == 0) {
          newStones.add((stone / 10.0.pow(stoneSize / 2)).toInt())
          newStones.add((stone % 10.0.pow(stoneSize / 2)).toInt())
          continue
        }
        newStones.add(stone * 2024)
      }
      stones = newStones
    }
    return stones.size
  }

  fun solvePart2(): Int = 1
}

fun main() {
  println(Day11(ParseFile.parseFileToListOfInt("day11/input.txt", " ")).solvePart1(25))
  println(Day11(ParseFile.parseFileToListOfInt("day11/input.txt", " ")).solvePart2())
}

package day11

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day11Test {
  @Test
  fun part1() {
    assertEquals(55312, Day11(ParseFile.parseFileToListOfInt("day11/test.txt", " ")).solvePart1(25))
  }

  @Test
  fun part2() {
    assertEquals(81, Day11(ParseFile.parseFileToListOfInt("day11/test.txt", " ")).solvePart2())
  }
}

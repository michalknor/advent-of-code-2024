package day07

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day07Test {
  @Test
  fun part1() {
    assertEquals(3749, Day07(ParseFile.parseFileToList("day07/test.txt")).solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(11387, Day07(ParseFile.parseFileToList("day07/test.txt")).solvePart2())
  }
}

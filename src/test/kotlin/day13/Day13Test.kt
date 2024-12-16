package day13

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day13Test {
  @Test
  fun part1() {
    assertEquals(480, Day13(ParseFile.parseFileToString("day13/test.txt")).solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(875318608908, Day13(ParseFile.parseFileToString("day13/test.txt")).solvePart2())
  }
}

package day05

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day05Test {
  @Test
  fun part1() {
    assertEquals(143, Day05(ParseFile.parseFileToString("day05/test.txt")).solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(123, Day05(ParseFile.parseFileToString("day05/test.txt")).solvePart2())
  }
}

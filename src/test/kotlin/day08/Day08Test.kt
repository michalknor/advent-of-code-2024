package day08

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day08Test {
  @Test
  fun part1() {
    assertEquals(14, Day08(ParseFile.parseFileToListOfListOfChars("day08/test.txt")).solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(14, Day08(ParseFile.parseFileToListOfListOfChars("day08/test.txt")).solvePart2())
  }
}

package day06

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day06Test {
  @Test
  fun part1() {
    assertEquals(41, Day06(ParseFile.parseFileToListOfListOfChars("day06/test.txt")).solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(6, Day06(ParseFile.parseFileToListOfListOfChars("day06/test.txt")).solvePart2())
  }
}

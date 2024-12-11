package day10

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day10Test {
  @Test
  fun part1() {
    assertEquals(36, Day10(ParseFile.parseFileToListOfListOfInt("day10/test.txt", "")).solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(81, Day10(ParseFile.parseFileToListOfListOfInt("day10/test.txt", "")).solvePart2())
  }
}

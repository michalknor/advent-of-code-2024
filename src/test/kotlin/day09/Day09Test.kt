package day09

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day09Test {
  @Test
  fun part1() {
    assertEquals(1928, Day09(ParseFile.parseFileToListOfInt("day09/test.txt")).solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(2858, Day09(ParseFile.parseFileToListOfInt("day09/test.txt")).solvePart2())
  }
}

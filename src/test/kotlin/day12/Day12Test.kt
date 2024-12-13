package day12

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day12Test {
  @Test
  fun part1() {
    assertEquals(140, Day12(ParseFile.parseFileToListOfListOfChars("day12/test.txt")).solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(1, Day12(ParseFile.parseFileToListOfListOfChars("day12/test.txt")).solvePart2())
  }
}

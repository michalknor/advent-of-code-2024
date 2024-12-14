package day12

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day12Test {
  @Test
  fun part1() {
    assertEquals(140, Day12(ParseFile.parseFileToListOfListOfChars("day12/test.txt")).solvePart1())
    assertEquals(
        1930, Day12(ParseFile.parseFileToListOfListOfChars("day12/test2.txt")).solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(80, Day12(ParseFile.parseFileToListOfListOfChars("day12/test.txt")).solvePart2())
    assertEquals(
        1206, Day12(ParseFile.parseFileToListOfListOfChars("day12/test2.txt")).solvePart2())
  }
}

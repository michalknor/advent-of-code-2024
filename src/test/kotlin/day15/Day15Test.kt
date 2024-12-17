package day15

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day15Test {
  @Test
  fun part1() {
    assertEquals(10092, Day15(ParseFile.parseFileToString("day15/test.txt")).solvePart1())
  }

  @Test
  fun part2() {
    assertEquals(9021, Day15(ParseFile.parseFileToString("day15/test.txt")).solvePart2())
  }
}

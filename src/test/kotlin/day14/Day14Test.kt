package day14

import kotlin.test.Test
import kotlin.test.assertEquals
import utils.ParseFile

class Day14Test {
  @Test
  fun part1() {
    assertEquals(12, Day14(ParseFile.parseFileToList("day14/test.txt")).solvePart1(11, 7))
  }
}

package utils

internal object Direction {
  enum class DirectionType(val dx: Int, val dy: Int) {
    N(0, -1),
    NE(1, -1),
    E(1, 0),
    SE(1, 1),
    S(0, 1),
    SW(-1, 1),
    W(-1, 0),
    NW(-1, -1)
  }

  fun getAllDirections(): List<DirectionType> =
      listOf(
              DirectionType.N,
              DirectionType.NE,
              DirectionType.E,
              DirectionType.SE,
              DirectionType.S,
              DirectionType.SW,
              DirectionType.W,
              DirectionType.NW)
          .toList()
}

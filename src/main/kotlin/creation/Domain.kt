package creation

enum class PieceNotation(val value: String) {
    WhitePawnNotation("WhitePawn"),
    BlackPawnNotation("BlackPawn"),
    WhiteHorseNotation("WhiteHorse"),
    BlackHorseNotation("WhiteHorse"),
    WhiteKnightNotation("Whiteknight"),
    BlackKnightNotation("Whiteknight")
}

sealed class PieceNotationAF(open val value: String)

data class PawnNotation(override val value: String) : PieceNotationAF(value)
data class HorseNotation(override val value: String) : PieceNotationAF(value)
data class KnightNotation(override val value: String) : PieceNotationAF(value)

val notation = listOf(PieceNotation.WhitePawnNotation, PieceNotation.BlackKnightNotation)
val notationAF = listOf(PawnNotation("WhitePawn"), HorseNotation("BlackHorse"))

class Pawn(
    override val position: Pair<Int, Int>
) : Piece(position)

class Horse(
    override val position: Pair<Int, Int>
) : Piece(position)

class Knight(
    override val position: Pair<Int, Int>
) : Piece(position)



package creation

import creation.PieceNotation.*

// this is a poc for a small chess
// to refresh factory pattern in kotlin
// now we start with the FactoryMethod pattern.
// this is a very simple pattern and used mostly when a
// small number of factory objects are used. Or when
// simplicity overrides necessity for more complicated
// solutions like AbstractFactory.

// pieces are stored as position Pair(3, 5) - for presentation the number will be
// mapped to a letter A-H
sealed class Piece(open val position: Pair<Int, Int>) {
    companion object {
        fun fromNotation(pieceNotation: PieceNotation): Piece = when(pieceNotation) {
            WhitePawnNotation -> Pawn(Pair(1, 3))
            WhiteHorseNotation -> Horse(Pair(1, 3))
            WhiteKnightNotation -> Knight(Pair(1, 3))
            BlackPawnNotation -> Pawn(Pair(1, 3))
            BlackHorseNotation -> Horse(Pair(1, 3))
            BlackKnightNotation -> Knight(Pair(1, 3))
            else -> error("could not determine type")
        }
    }
}

fun main() {
    val gameState = notation.map { pieceNotation -> Piece.fromNotation(pieceNotation) }
    println("we expect a list of 2 pieces: $gameState")
    assert(gameState.isNotEmpty())
    assert(gameState.size == 2)
    assert(gameState[0] is Pawn)
    assert(gameState[1] is Horse)
}


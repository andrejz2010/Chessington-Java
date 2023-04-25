package chessington.model.pieces;

import chessington.model.Board;
import chessington.model.Coordinates;
import chessington.model.Move;
import chessington.model.PlayerColour;
import org.junit.jupiter.api.Test;

import java.util.List;

import static chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KingTest {
    @Test
    public void WhiteKingCanMoveUpOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));


    }

    @Test
    public void BlackKingCanMoveUpOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));


    }

    @Test
    public void BlackKingCanMoveDownOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 0)));


    }

    @Test
    public void BlackKingCanMoveUpSquare() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));


    }
    @Test
    public void KingCanMoveLeft() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, -1)));


    }
    @Test
    public void KingCanMoveRight() {
        // Arrange
        Board board = Board.empty();
        Piece king = new King(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, king);

        // Act
        List<Move> moves = king.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(0, 1)));


    }

}





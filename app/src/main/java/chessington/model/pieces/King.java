package chessington.model.pieces;

import chessington.model.Board;
import chessington.model.Coordinates;
import chessington.model.Move;
import chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {
    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    boolean pieceIsWhite = (this.colour == PlayerColour.WHITE);

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> allowedMoves = new ArrayList<>();

        boolean pieceIsAtTheBotom = from.getRow() == 7;
        boolean pieceIsAtTheTop = from.getRow() == 0;
        boolean pieceIsOnTheLeft = from.getRow() == 0;
        boolean pieceIsOnTheRight = from.getRow() == 7;



        if (!pieceIsAtTheTop && squareIsEmpty(from.plus(-1,0), board)) {
            Move allowedMove = new Move(from, from.plus(-1, 0));
            allowedMoves.add(allowedMove);                                                      //move down

        }

        if (!pieceIsAtTheBotom && squareIsEmpty(from.plus(1,0), board)) {
            Move allowedMove = new Move(from, from.plus(1, 0));                       //move up
            allowedMoves.add(allowedMove);
        }

        if (!pieceIsOnTheLeft && squareIsEmpty(from.plus(0,-1), board)) {
            Move allowedMove = new Move(from, from.plus(0, -1));                       //move left
            allowedMoves.add(allowedMove);
        }
        if (!pieceIsOnTheRight && squareIsEmpty(from.plus(0,+1), board)) {
            Move allowedMove = new Move(from, from.plus(0, +1));                       //Move Right
            allowedMoves.add(allowedMove);
        }
        if (!pieceIsOnTheRight && !pieceIsAtTheBotom && squareIsEmpty(from.plus(+1,+1), board)) {
            Move allowedMove = new Move(from, from.plus(+1, +1));                       //Move Right and Down
            allowedMoves.add(allowedMove);
        }
        if (!pieceIsOnTheRight && !pieceIsAtTheTop && squareIsEmpty(from.plus(-1,+1), board)) {
            Move allowedMove = new Move(from, from.plus(-1, +1));                       //Move Right and Up
            allowedMoves.add(allowedMove);
        }
        if (!pieceIsOnTheRight && !pieceIsAtTheTop && squareIsEmpty(from.plus(-1,-1), board)) {
            Move allowedMove = new Move(from, from.plus(-1, -1));                       //Move Left and Up
            allowedMoves.add(allowedMove);
        }
        if (!pieceIsOnTheRight && !pieceIsAtTheBotom && squareIsEmpty(from.plus(+1,-1), board)) {
            Move allowedMove = new Move(from, from.plus(+1, -1));                       //Move Left and Down
            allowedMoves.add(allowedMove);
        }


        return allowedMoves;
    }
}
package chessington.model.pieces;

import chessington.model.Board;
import chessington.model.Coordinates;
import chessington.model.Move;
import chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import static chessington.model.PlayerColour.BLACK;
import static chessington.model.PlayerColour.WHITE;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        ArrayList<Move> allowedMoves= new ArrayList<Move>();

        if (this.colour==WHITE) {
            Coordinates to1 = new Coordinates(from.getRow()-1, from.getCol());
            Move allowedMove1=new Move(from, to1);
            allowedMoves.add(allowedMove1);
        } else if (this.colour==BLACK){
            Coordinates to2 = new Coordinates(from.getRow()+1, from.getCol());
            Move allowedMove2=new Move(from, to2);
            allowedMoves.add(allowedMove2);

        }

       return allowedMoves;
    }
}

package chessington.model.pieces;

import chessington.model.Board;
import chessington.model.Coordinates;
import chessington.model.Move;
import chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        Coordinates to1 = new Coordinates(from.getRow()+1, from.getCol());
        Coordinates to2 = new Coordinates(from.getRow()-1, from.getCol());
        Move allowedMove1=new Move(from, to1);
         Move allowedMove2=new Move(from, to2);
       ArrayList<Move> allowedMoves= new ArrayList<Move>();
       allowedMoves.add(allowedMove1);
       allowedMoves.add(allowedMove2);
       return allowedMoves;
    }
}
